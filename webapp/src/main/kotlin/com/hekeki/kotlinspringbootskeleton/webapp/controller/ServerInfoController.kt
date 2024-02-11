package com.hekeki.kotlinspringbootskeleton.webapp.controller

import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("api/v1")
class ServerInfoController {

    @GetMapping("/ping", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun ping(): ResponseEntity<String> {
        return ResponseEntity.ok("pong (" + LocalDateTime.now() + ")")
    }
}
