package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.models.Course
import br.com.matheuscordeiro.forum.repositories.CourseRepository
import br.com.matheuscordeiro.forum.services.CourseService
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(private val courseRepository: CourseRepository) : CourseService {
    override fun findById(id: Long): Course {
        return courseRepository.getReferenceById(id)
    }
}