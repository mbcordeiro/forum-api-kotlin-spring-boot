package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.mappers.TopicRequestMapper
import br.com.matheuscordeiro.forum.mappers.TopicResponseMapper
import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
import br.com.matheuscordeiro.forum.models.Topic
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
}