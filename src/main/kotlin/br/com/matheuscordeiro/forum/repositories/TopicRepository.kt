package br.com.matheuscordeiro.forum.repositories

import br.com.matheuscordeiro.forum.dto.TopicByCategoryDto
import br.com.matheuscordeiro.forum.models.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<Topic, Long> {
    fun findByCourseName(nameCourse: String, pageable: Pageable): Page<Topic>

    @Query("SELECT NEW br.com.matheuscordeiro.forum.dto.TopicByCategoryDto(course.category, COUNT(t)) "
            + "FROM Topic t JOIN t.course GROUP BY course.category")
    fun reportByCategory(): List<TopicByCategoryDto>

}