package com.example.vacation.controller

import com.example.vacation.entity.Post
import com.example.vacation.service.PostService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/posts")
class PostController(private val postService: PostService) {
    @GetMapping
    fun list(model: Model): String {
        model.addAttribute("posts", postService.findAll())
        return "posts/list"
    }

    @GetMapping("/{id}")
    fun view(@PathVariable id: Long, model: Model): String {
        model.addAttribute("post", postService.findById(id))
        return "posts/view"
    }

    @GetMapping("/new")
    fun createForm(model: Model): String {
        model.addAttribute("post", Post(title = "", content = "", author = ""))
        return "posts/form"
    }

    @PostMapping
    fun create(@ModelAttribute post: Post): String {
        postService.save(post)
        return "redirect:/posts"
    }

    @PostMapping("/{id}/delete")
    fun delete(@PathVariable id: Long): String {
        postService.deleteById(id)
        return "redirect:/posts"
    }
}
