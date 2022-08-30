package br.com.matheuscordeiro.forum.repositories

import br.com.matheuscordeiro.forum.models.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long>{
}