package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.models.Course
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.models.User
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(private var topics: List<Topic>) : TopicService {
    init {
        val topic = Topic(
            id = 1,
            tittle = "Kotlin",
            message = "kotlin",
            course = Course(1, name = "Kotlin", category = "Programming"),
            author = User(id = 1, name = "Matheus Cordeiro", email = "email@email.com")
        )

        val topic2 = Topic(
            id = 2,
            tittle = "Kotlin 2",
            message = "kotlin 2",
            course = Course(1, name = "Kotlin", category = "Programming"),
            author = User(id = 1, name = "Matheus Cordeiro", email = "email@email.com")
        )

        val topic3 = Topic(
            id = 3,
            tittle = "Kotlin 3",
            message = "kotlin 3",
            course = Course(1, name = "Kotlin", category = "Programming"),
            author = User(id = 1, name = "Matheus Cordeiro", email = "email@email.com")
        )
        topics = listOf(topic, topic2, topic3)
    }

    override fun findList(): List<Topic> {
        return topics
    }
}