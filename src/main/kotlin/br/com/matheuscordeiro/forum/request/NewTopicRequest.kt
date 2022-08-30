package br.com.matheuscordeiro.forum.request

data class NewTopicRequest(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long)
