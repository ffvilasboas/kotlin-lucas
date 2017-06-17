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
    fun findAll(){
        var lista: List<Pessoa> = repository.findAll();
        for(pessoa in lista){
            log.info(pessoa.toString())
        }
        lista
    }

    @RequestMapping("/database/{nomeCompleto}")
    fun findByLastName(@PathVariable nomeCompleto:String){
        log.info("Procurando pelo cliente: " +nomeCompleto)
        repository.findByNomeCompleto(nomeCompleto)
    }


    @RequestMapping("/database/incluir", method = arrayOf(RequestMethod.POST))
    fun salvarPessoa(@RequestBody pessoa: Pessoa){
        var pessoa = repository.save(pessoa)
        log.info("Incluindo o cliente: " +pessoa.toString())
        pessoa
    }
}