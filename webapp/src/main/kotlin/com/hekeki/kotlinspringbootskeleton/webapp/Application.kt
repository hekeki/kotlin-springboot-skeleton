package com.hekeki.kotlinspringbootskeleton.webapp

import java.util.*
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    Locale.setDefault(Locale.ENGLISH)
    SpringApplication.run(Application::class.java, *args)
}