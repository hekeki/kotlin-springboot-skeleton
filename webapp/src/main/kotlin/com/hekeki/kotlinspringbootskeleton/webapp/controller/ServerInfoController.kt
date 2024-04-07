package com.hekeki.kotlinspringbootskeleton.webapp.controller

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import java.time.LocalDateTime

@RestController
@HttpExchange("api/v1")
class ServerInfoController {

    @GetExchange(value = "/ping", accept = [MediaType.TEXT_PLAIN_VALUE])
    fun ping(): ResponseEntity<String> {
        return ResponseEntity.ok("pong (" + LocalDateTime.now() + ")")
    }
}
