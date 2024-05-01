package com.hekeki.kotlinspringbootskeleton.webapp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http {
            csrf {
                ignoringRequestMatchers("/api/v1/**")
            }
            authorizeHttpRequests {
                authorize("/api/v1/**", permitAll)
                authorize("/css/**", permitAll)
                authorize("/**", authenticated)
            }
            formLogin {
                loginPage = "/login"
                permitAll()
            }
            logout {
                logoutSuccessUrl = "/login"
            }
        }

        return http.build()
    }

    @Bean
    fun inMemoryUserDetailsManager(): UserDetailsService {
        val user: UserDetails = User
            .withUsername("user")
            .password(passwordEncoder().encode("user"))
            .roles("USER")
            .build()

        val admin: UserDetails = User
            .withUsername("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN")
            .build()

        return InMemoryUserDetailsManager(user, admin)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8()
    }
}