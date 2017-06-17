package database

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by kritiuns on 16/06/17.
 */
interface PessoaRepository : JpaRepository<Pessoa, Long> {
    fun findByNomeCompleto(nomeCompleto: String): Iterable<Pessoa>
}