package br.com.matheuscordeiro.forum.repositories

import br.com.matheuscordeiro.forum.models.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long>{
    fun findByCourseName(nameCourse: String, pageable: Pageable): Page<Topic>
}