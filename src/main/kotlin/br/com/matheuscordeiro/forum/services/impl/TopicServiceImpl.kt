package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.mappers.TopicRequestMapper
import br.com.matheuscordeiro.forum.mappers.TopicResponseMapper
import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.requests.UpdateTopicRequest
import br.com.matheuscordeiro.forum.services.UserService
import br.com.matheuscordeiro.forum.services.CourseService
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private var topics: List<Topic>,
    private val topicResponseMapper: TopicResponseMapper,
    private val topicRequestMapper: TopicRequestMapper
) : TopicService {
    override fun findList(): List<TopicResponse> {
        return topics.map {
            topicResponseMapper.map(it)
        }
    }

    override fun findById(id: Long): TopicResponse {
        return topicResponseMapper.map(topics.first {
            it.id == id
        })
    }

    override fun insert(newTopicRequest: NewTopicRequest) {
        val topic = topicRequestMapper.map(newTopicRequest)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    override fun update(updateTopicRequest: UpdateTopicRequest) {
        val topic = topics.first {
            it.id == updateTopicRequest.id
        }
        topics = topics.minus(topic).plus(
            Topic(
                id = updateTopicRequest.id,
                tittle = updateTopicRequest.title,
                message = updateTopicRequest.message,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                status = topic.status,
                dateCreation = topic.dateCreation
            )
        )
    }

    override fun delete(id: Long) {
        topics.minus(topics.first {
            it.id == id
        })
    }
}