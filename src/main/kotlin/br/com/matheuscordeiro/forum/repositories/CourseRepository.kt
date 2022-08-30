package br.com.matheuscordeiro.forum.repositories

import br.com.matheuscordeiro.forum.models.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {
}