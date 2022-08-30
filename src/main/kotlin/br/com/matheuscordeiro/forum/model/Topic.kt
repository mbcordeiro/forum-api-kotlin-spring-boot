package br.com.matheuscordeiro.forum.model

import java.time.LocalDateTime

data class Topic(
    val id: Long? = null,
    val tittle: String,
    val message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(),
    val course: String,
    val author: String,
    val status: String
)