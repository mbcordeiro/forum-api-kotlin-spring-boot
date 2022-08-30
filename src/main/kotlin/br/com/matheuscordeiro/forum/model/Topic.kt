package br.com.matheuscordeiro.forum.model

import br.com.matheuscordeiro.forum.model.enums.TopicStatus
import java.time.LocalDateTime

data class Topic(
    val id: Long? = null,
    val tittle: String,
    val message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.UNANSWERED
)