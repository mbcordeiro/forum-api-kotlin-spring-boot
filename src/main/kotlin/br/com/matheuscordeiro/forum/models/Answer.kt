package br.com.matheuscordeiro.forum.models

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solved: Boolean
)
