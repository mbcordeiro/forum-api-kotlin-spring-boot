package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.models.Answer

interface AnswerService {
    fun save(answer: Answer)
}