package database

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by kritiuns on 16/06/17.
 */
@RestController
class PessoaControler  @Autowired constructor(val repository:PessoaRepository) {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @RequestMapping("/database")
    fun findAll(): List<Pessoa>{
        var lista: List<Pessoa> = repository.findAll()
        for(pessoa in lista){
            log.info(pessoa.toString())
        }
        return lista
    }

    @RequestMapping("/database/{nomeCompleto}")
    fun findByLastName(@PathVariable nomeCompleto:String):Iterable<Pessoa>{
        log.info("Procurando pelo cliente: " +nomeCompleto)
        return repository.findByNomeCompleto(nomeCompleto)
    }


    @RequestMapping("/database/incluir", method = arrayOf(RequestMethod.POST))
    fun salvarPessoa(@RequestBody pessoa: Pessoa): Pessoa{
        var pessoa = repository.save(pessoa)
        log.info("Incluindo o cliente: " +pessoa.toString())
        return pessoa
    }

    @RequestMapping("/database/atualizar", method = arrayOf(RequestMethod.POST))
    fun atualizarPessoa(@RequestBody pessoa: Pessoa): Pessoa{
        var pessoa = repository.save(pessoa)
        log.info("Cliente atualizado: " +pessoa.toString())
        return pessoa
    }
}