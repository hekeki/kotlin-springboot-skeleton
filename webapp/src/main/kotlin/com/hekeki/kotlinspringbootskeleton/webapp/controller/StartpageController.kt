package com.hekeki.kotlinspringbootskeleton.webapp.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class StartpageController {

    @GetMapping("/")
    fun startpage(model: Model): String {
        return "index"
    }
}