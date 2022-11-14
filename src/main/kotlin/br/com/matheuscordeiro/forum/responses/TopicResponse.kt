package br.com.matheuscordeiro.forum.responses

import br.com.matheuscordeiro.forum.models.enums.TopicStatus
import java.time.LocalDate
import java.time.LocalDateTime

data class TopicResponse(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val dateCreation: LocalDateTime,
    val dateUpdate: LocalDate?
)
