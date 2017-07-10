package database

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*


/**
 * Created by kritiuns on 16/06/17.
 */
@RestController
@RequestMapping("/database/")
class PessoaControler  @Autowired constructor(val repository:PessoaRepository) {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @RequestMapping("/lista", method = arrayOf(RequestMethod.GET))
    fun findAll(): List<Pessoa>{
        var lista: List<Pessoa> = repository.findAll()
        for(pessoa in lista){
            log.info(pessoa.toString())
        }
        return lista
    }

    @RequestMapping("/listaClientesPendentes", method = arrayOf(RequestMethod.GET))
    fun findByVendeu(): List<Pessoa>{
        return repository.findByFechamento(Fechamento.INICIADO)
    }

    @RequestMapping("/incluir", method = arrayOf(RequestMethod.POST))
    fun salvarPessoa(@RequestBody pessoa: Pessoa): Pessoa{
        if(pessoa.status.equals(Status.VENDIDO) || pessoa.status.equals(Status.PERDIDO)){
            pessoa.fechamento = Fechamento.FINALZIADO
        }

        pessoa.dataCriacao = Date().time
        var pessoa = repository.save(pessoa)
        log.info("Incluindo o cliente: " +pessoa.toString())
        return pessoa
    }
}