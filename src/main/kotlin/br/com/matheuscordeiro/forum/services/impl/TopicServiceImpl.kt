package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.exceptions.NotFoundException
import br.com.matheuscordeiro.forum.mappers.TopicRequestMapper
import br.com.matheuscordeiro.forum.mappers.TopicResponseMapper
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.requests.UpdateTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
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
        return topicResponseMapper.map(findFirstById(id))
    }

    override fun insert(newTopicRequest: NewTopicRequest): TopicResponse {
        val topic = topicRequestMapper.map(newTopicRequest)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicResponseMapper.map(topic)
    }

    override fun update(updateTopicRequest: UpdateTopicRequest): TopicResponse {
        val topic = findFirstById(updateTopicRequest.id)
        val updateTopic = Topic(
            id = updateTopicRequest.id,
            tittle = updateTopicRequest.title,
            message = updateTopicRequest.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            dateCreation = topic.dateCreation
        )
        topics = topics.minus(topic).plus(updateTopic)
        return topicResponseMapper.map(updateTopic)
    }

    override fun delete(id: Long) {
        topics.minus(findFirstById(id))
    }

    fun findFirstById(id: Long): Topic {
        try {
            return topics.first {
                it.id == id
            }
        } catch (e: NotFoundException) {
            throw NotFoundException("Topic not found!");
        }
    }
}