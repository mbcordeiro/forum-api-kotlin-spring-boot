package br.com.matheuscordeiro.forum.model

import br.com.matheuscordeiro.forum.models.enums.TopicStatus
import br.com.matheuscordeiro.forum.responses.TopicResponse
import java.time.LocalDate
import java.time.LocalDateTime

object TopicResponseTest {
    fun build() = TopicResponse(
        id = 1,
        title = "Kotlin Basic",
        message = "Learn Kotlin",
        status = TopicStatus.NOT_SOLVED,
        dateCreation = LocalDateTime.now(),
        dateUpdate = LocalDate.now()
    )
}