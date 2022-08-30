package br.com.matheuscordeiro.forum.requests

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class NewTopicRequest(
    @field:NotEmpty val title: String,
    @field:NotEmpty val message: String,
    @field:NotNull val idCourse: Long,
    @field:NotNull val idAuthor: Long
)
