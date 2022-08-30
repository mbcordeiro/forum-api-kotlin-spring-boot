package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.models.Topic

interface TopicService {
    fun findList(): List<Topic>
    fun findById(id: Long): Topic
    fun insert(topic: Topic)
}