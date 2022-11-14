package br.com.matheuscordeiro.forum.model

import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.models.enums.TopicStatus

object TopicTest {
    fun build() = Topic(
        id = 1,
        tittle = "Kotlin Basic",
        message = "Learn Kotlin",
        status = TopicStatus.NOT_SOLVED,
        course = CourseTest.build(),
        author = UserTest.build()
    )
}