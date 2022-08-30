package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.models.Course
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.models.User
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(private var topics: List<Topic>) : TopicService {
    override fun findList(): List<Topic> {
        return topics
    }

    override fun findById(id: Long): Topic {
        return topics.first {
            it.id == id
        }
    }

    override fun insert(topic: Topic) {
        topics.plus(topic)
    }
}