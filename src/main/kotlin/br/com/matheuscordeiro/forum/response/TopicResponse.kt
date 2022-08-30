package br.com.matheuscordeiro.forum.response

import br.com.matheuscordeiro.forum.models.enums.TopicStatus
import java.time.LocalDateTime

data class TopicResponse(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val dateCreation: LocalDateTime
)
