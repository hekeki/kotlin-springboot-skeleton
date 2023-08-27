package com.hekeki.kotlinspringbootskeleton.webapp.controller

import com.hekeki.kotlinspringbootskeleton.api.v1.ServerInfoIF
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class ServerInfoController : ServerInfoIF {

    override fun ping(): String {
        return "pong (" + LocalDateTime.now() + ")"
    }
}
