package database

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

/**
 * Created by kritiuns on 10/06/17.
 */
@SpringBootApplication
open class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    open fun init(repository: PessoaRepository) = CommandLineRunner {

        /* save a couple of customers
        repository.save(Pessoa("Lucas Ramos 1", 27, "lucas1@lucas.com.br", "Whatapp", "11973672751"))
        repository.save(Pessoa("Lucas Ramos 2", 27, "lucas2@lucas.com.br", "Telefone", "11973672752"))
        repository.save(Pessoa("Lucas Ramos 3", 27, "lucas3@lucas.com.br", "Email", "11973672753"))
        repository.save(Pessoa("Lucas Ramos 4", 27, "lucas4@lucas.com.br", "Telefone", "11973672754"))
        repository.save(Pessoa("Lucas Ramos 5", 27, "lucas5@lucas.com.br", "Email", "11973672755"))
        */

        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        for (customer in repository.findAll()) {
            log.info(customer.toString())
        }
        log.info("")

        // fetch an individual customer by ID
        val customer = repository.findOne(1L)
        log.info("Customer found with findOne(1L):")
        log.info("--------------------------------")
        log.info(customer.toString())
        log.info("")

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):")
        log.info("--------------------------------------------")
        for (bauer in repository.findByNomeCompleto("Lucas Ramos 1")) {
            log.info(bauer.toString())
        }
        log.info("")
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}
