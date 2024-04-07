package com.hekeki.kotlinspringbootskeleton.webapp.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun login(model: Model): String {
        return "login"
    }

    @PostMapping("/login")
    fun authenticate(model: Model): String {
        return "redirect:/"
    }
}