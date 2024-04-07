package com.hekeki.kotlinspringbootskeleton.webapp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http.invoke {
            csrf {
                ignoringRequestMatchers("/api/v1/**")
            }
            authorizeHttpRequests {
                authorize("/actuator", authenticated)
                authorize("/api/v1/**", permitAll)
                authorize("/**", permitAll)
            }
            httpBasic { }
        }

        return http.build()
    }
}