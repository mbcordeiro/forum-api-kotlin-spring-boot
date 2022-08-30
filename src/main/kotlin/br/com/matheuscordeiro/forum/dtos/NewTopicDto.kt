package br.com.matheuscordeiro.forum.dtos

import br.com.matheuscordeiro.forum.models.Course
import br.com.matheuscordeiro.forum.models.User

data class NewTopicDto(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long)
