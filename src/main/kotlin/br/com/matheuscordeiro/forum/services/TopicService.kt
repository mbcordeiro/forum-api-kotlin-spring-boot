package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.request.NewTopicRequest
import br.com.matheuscordeiro.forum.response.TopicResponse

interface TopicService {
    fun findList(): List<TopicResponse>
    fun findById(id: Long): TopicResponse
    fun insert(newTopicRequest: NewTopicRequest)
}