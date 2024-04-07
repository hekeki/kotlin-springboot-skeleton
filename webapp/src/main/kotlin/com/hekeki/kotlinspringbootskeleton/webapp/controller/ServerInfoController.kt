package com.hekeki.kotlinspringbootskeleton.webapp.controller

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("api/v1")
class ServerInfoController {

    @GetMapping("/ping", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun ping(): ResponseEntity<String> {
        return ResponseEntity.ok("pong (" + LocalDateTime.now() + ")")
    }
}
