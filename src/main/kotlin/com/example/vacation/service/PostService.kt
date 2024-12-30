package com.example.vacation.service

import com.example.vacation.entity.Post
import com.example.vacation.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(private val postRepository: PostRepository) {
    fun findAll(): List<Post> = postRepository.findAll()
    fun findById(id: Long): Post = postRepository.findById(id).orElseThrow { RuntimeException("Post not found") }
    fun save(post: Post): Post = postRepository.save(post)
    fun deleteById(id: Long) = postRepository.deleteById(id)
}
