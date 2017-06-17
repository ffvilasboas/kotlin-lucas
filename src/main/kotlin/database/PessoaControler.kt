package database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by kritiuns on 16/06/17.
 */
@RestController
class PessoaControler  @Autowired constructor(val repository:PessoaRepository) {

    @RequestMapping("/database")
    fun findAll() = repository.findAll()

    @RequestMapping("/database/{nomeCompleto}")
    fun findByLastName(@PathVariable nomeCompleto:String)
            = repository.findByNomeCompleto(nomeCompleto)

    @RequestMapping("/database/incluir", method = arrayOf(RequestMethod.POST))
    fun salvarPessoa(@RequestBody pessoa: Pessoa) = repository.save(pessoa)
}