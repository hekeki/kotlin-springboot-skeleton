package com.hekeki.kotlinspringbootskeleton.api.v1

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("api/v1")
interface ServerInfoIF {

    @GetMapping("/ping", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun ping(): String
}
