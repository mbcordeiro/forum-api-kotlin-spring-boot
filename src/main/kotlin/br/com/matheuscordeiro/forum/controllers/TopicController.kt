package br.com.matheuscordeiro.forum.controllers

import br.com.matheuscordeiro.forum.models.Course
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.models.User
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {
    @GetMapping
    fun getList(): List<Topic> {
        return topicService.findList()
    }
}