package com.example.vacation.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("message", "Welcome to Thymeleaf with Kotlin!")
        return "index" // templates/index.html을 반환
    }
}
