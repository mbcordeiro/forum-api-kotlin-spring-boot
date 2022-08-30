package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.models.Course

interface CourseService {
    fun findById(id: Long): Course
}
