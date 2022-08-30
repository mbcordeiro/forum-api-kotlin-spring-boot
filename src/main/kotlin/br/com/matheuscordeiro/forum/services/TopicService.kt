package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.requests.UpdateTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse

interface TopicService {
    fun findList(): List<TopicResponse>
    fun findById(id: Long): TopicResponse
    fun insert(newTopicRequest: NewTopicRequest): TopicResponse
    fun update(updateTopicRequest: UpdateTopicRequest): TopicResponse
    fun delete(id: Long)
}