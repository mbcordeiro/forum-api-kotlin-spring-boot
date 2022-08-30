package br.com.matheuscordeiro.forum.controllers

import br.com.matheuscordeiro.forum.model.Course
import br.com.matheuscordeiro.forum.model.Topic
import br.com.matheuscordeiro.forum.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController {
    @GetMapping
    fun getList(): List<Topic> {
        val topic = Topic(
            id = 1,
            tittle = "Kotlin",
            message = "kotlin",
            course = Course(1, name = "Kotiln", category = "Programation"),
            author = User(id = 1, name = "Matheus Cordeiro", email = "email@email.com")
        )
        return listOf(topic, topic, topic)
    }
}