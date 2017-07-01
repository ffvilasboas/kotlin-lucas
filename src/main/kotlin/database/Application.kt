package database

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


/**
 * Created by kritiuns on 10/06/17.
 */
@SpringBootApplication
open class Application{

    private val log = LoggerFactory.getLogger(Application::class.java)


    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}
