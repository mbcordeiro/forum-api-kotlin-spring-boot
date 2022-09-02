package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.dto.TopicByCategoryDto
import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.requests.UpdateTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicService {
    fun findList(nameCourse: String?, pageable: Pageable): Page<TopicResponse>
    fun findById(id: Long): TopicResponse
    fun insert(newTopicRequest: NewTopicRequest): TopicResponse
    fun update(updateTopicRequest: UpdateTopicRequest): TopicResponse
    fun delete(id: Long)
    fun reportByCategory(): List<TopicByCategoryDto>
}