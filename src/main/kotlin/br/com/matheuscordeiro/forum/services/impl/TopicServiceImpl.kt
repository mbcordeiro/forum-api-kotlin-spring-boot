package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.exceptions.NotFoundException
import br.com.matheuscordeiro.forum.mappers.TopicRequestMapper
import br.com.matheuscordeiro.forum.mappers.TopicResponseMapper
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.repositories.TopicRepository
import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.requests.UpdateTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TopicServiceImpl(
    private val topicRepository: TopicRepository,
    private val topicResponseMapper: TopicResponseMapper,
    private val topicRequestMapper: TopicRequestMapper
) : TopicService {
    override fun findList(nameCourse: String?, pageable: Pageable): Page<TopicResponse> {
        val topics = if (nameCourse == null) {
            topicRepository.findAll(pageable)
        } else {
            topicRepository.findByCourseName(nameCourse, pageable)
        }
        return topics.map {
            topicResponseMapper.map(it)
        }
    }

    override fun findById(id: Long): TopicResponse {
        return topicResponseMapper.map(findFirstById(id))
    }

    @Transactional
    override fun insert(newTopicRequest: NewTopicRequest): TopicResponse {
        val topic = topicRequestMapper.map(newTopicRequest)
        topicRepository.save(topic)
        return topicResponseMapper.map(topic)
    }

    @Transactional
    override fun update(updateTopicRequest: UpdateTopicRequest): TopicResponse {
        val topic = findFirstById(updateTopicRequest.id)
        topic.tittle = updateTopicRequest.title
        topic.message = updateTopicRequest.message
        topicRepository.save(topic)
        return topicResponseMapper.map(topic)
    }

    override fun delete(id: Long) {
        topicRepository.deleteById(id)
    }

    fun findFirstById(id: Long): Topic {
        try {
            return topicRepository.getReferenceById(id)
        } catch (e: NotFoundException) {
            throw NotFoundException("Topic not found!");
        }
    }
}