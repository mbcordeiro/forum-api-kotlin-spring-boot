package br.com.matheuscordeiro.forum.controllers

import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {
    @GetMapping
    fun getList(): List<Topic> {
        return topicService.findList()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Topic {
        return topicService.findById(id)
    }

    @PostMapping
    fun create(@RequestBody topic: Topic) {
        topicService.insert(topic)
    }
}