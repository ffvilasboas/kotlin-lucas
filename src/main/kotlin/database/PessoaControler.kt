package database

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * Created by kritiuns on 16/06/17.
 */
@RestController
@RequestMapping("/database/")
class PessoaControler  @Autowired constructor(val repository:PessoaRepository) {

    private val log = LoggerFactory.getLogger(Application::class.java)


    @RequestMapping(value = "/**", method = arrayOf(RequestMethod.OPTIONS))
    fun handle(): ResponseEntity<HttpStatus>{
        return ResponseEntity(HttpStatus.OK)
    }

    @RequestMapping("/all")
    fun findAll(): List<Pessoa>{
        var lista: List<Pessoa> = repository.findAll()
        for(pessoa in lista){
            log.info(pessoa.toString())
        }
        return lista
    }

    @RequestMapping("/{nomeCompleto}")
    fun findByLastName(@PathVariable nomeCompleto:String):Iterable<Pessoa>{
        log.info("Procurando pelo cliente: " +nomeCompleto)
        return repository.findByNomeCompleto(nomeCompleto)
    }

    @RequestMapping("/incluir", method = arrayOf(RequestMethod.POST))
    fun salvarPessoa(@RequestBody pessoa: Pessoa): Pessoa{
        var pessoa = repository.save(pessoa)
        log.info("Incluindo o cliente: " +pessoa.toString())
        return pessoa
    }

    @RequestMapping("/atualizar", method = arrayOf(RequestMethod.POST))
    fun atualizarPessoa(@RequestBody pessoa: Pessoa): Pessoa{
        var pessoa = repository.save(pessoa)
        log.info("Cliente atualizado: " +pessoa.toString())
        return pessoa
    }
}