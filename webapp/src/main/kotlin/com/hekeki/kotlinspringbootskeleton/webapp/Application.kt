package com.hekeki.kotlinspringbootskeleton.webapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    Locale.setDefault(Locale.ENGLISH)
    SpringApplication.run(Application::class.java, *args)
}