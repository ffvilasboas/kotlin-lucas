package database

import org.springframework.context.annotation.Configuration
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.context.annotation.Bean
import org.springframework.web.filter.CorsFilter


/**
 * Created by kritiuns on 01/07/17.
 */
@Configuration
open class RestConfiguration {

    @Bean
    open fun corsFilter(): FilterRegistrationBean {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration().applyPermitDefaultValues()
        source.registerCorsConfiguration("/**", config)
        val bean = FilterRegistrationBean(CorsFilter(source))
        bean.order = 0
        return bean
    }
}