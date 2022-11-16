package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.dto.TopicByCategoryDto
import br.com.matheuscordeiro.forum.exceptions.NotFoundException
import br.com.matheuscordeiro.forum.mappers.TopicRequestMapper
import br.com.matheuscordeiro.forum.mappers.TopicResponseMapper
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.repositories.TopicRepository
import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.requests.UpdateTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class TopicServiceImpl(
    private val topicRepository: TopicRepository,
    private val topicResponseMapper: TopicResponseMapper,
    private val topicRequestMapper: TopicRequestMapper
) : TopicService {
    @Cacheable("topics")
    override fun findList(nameCourse: String?, pageable: Pageable): Page<TopicResponse> {
        val topics = nameCourse?.let {
            topicRepository.findByCourseName(nameCourse, pageable)
        } ?: topicRepository.findAll(pageable)
        return topics.map {
            topicResponseMapper.map(it)
        }
    }

    override fun findById(id: Long): TopicResponse {
        return topicResponseMapper.map(findFirstById(id))
    }

    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    override fun insert(newTopicRequest: NewTopicRequest): TopicResponse {
        val topic = topicRequestMapper.map(newTopicRequest)
        topicRepository.save(topic)
        return topicResponseMapper.map(topic)
    }

    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    override fun update(updateTopicRequest: UpdateTopicRequest): TopicResponse {
        val topic = findFirstById(updateTopicRequest.id)
        topic.tittle = updateTopicRequest.title
        topic.message = updateTopicRequest.message
        topic.dateUpdate = LocalDate.now()
        topicRepository.save(topic)
        return topicResponseMapper.map(topic)
    }

    @CacheEvict(value = ["topics"], allEntries = true)
    override fun delete(id: Long) {
        topicRepository.deleteById(id)
    }

    override fun reportByCategory(): List<TopicByCategoryDto> {
        return topicRepository.reportByCategory()
    }

    fun findFirstById(id: Long): Topic {
        try {
            return topicRepository.getReferenceById(id)
        } catch (e: NotFoundException) {
            throw NotFoundException("Topic not found!");
        }
    }
}