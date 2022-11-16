package br.com.matheuscordeiro.forum.repositories

import br.com.matheuscordeiro.forum.models.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<Answer, Long>