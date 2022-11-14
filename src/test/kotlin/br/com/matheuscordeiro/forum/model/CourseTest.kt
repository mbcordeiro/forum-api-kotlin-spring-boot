package br.com.matheuscordeiro.forum.model

import br.com.matheuscordeiro.forum.models.Course

object CourseTest {
    fun build() = Course(id = 1, name = "Kotlin Basic", category = "Programming")
}