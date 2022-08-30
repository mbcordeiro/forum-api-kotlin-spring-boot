package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.models.Course
import br.com.matheuscordeiro.forum.services.CourseService
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(private var courses: List<Course>) : CourseService {
    init {
        val course = Course(id = 1, name = "Kotlin", category = "Programming")
        courses = listOf(course);
    }

    override fun findById(id: Long): Course {
        return courses.first {
            it.id == id
        }
    }
}