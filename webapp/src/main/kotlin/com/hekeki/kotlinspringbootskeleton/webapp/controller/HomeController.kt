package com.hekeki.kotlinspringbootskeleton.webapp.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HomeController {

    @GetMapping("/")
    fun home(model: Model, @AuthenticationPrincipal user: User): String {
        model.addAttribute("username", user.username)
        return "home"
    }
}