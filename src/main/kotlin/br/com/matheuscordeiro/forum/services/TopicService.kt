package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.models.Topic

interface TopicService {
    fun findList(): List<Topic>
}