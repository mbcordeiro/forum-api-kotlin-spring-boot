package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.models.Answer
import br.com.matheuscordeiro.forum.repositories.AnswerRepository
import br.com.matheuscordeiro.forum.services.AnswerService
import br.com.matheuscordeiro.forum.services.EmailService
import org.springframework.stereotype.Service

@Service
class AnswerServiceImpl(private val answerRepository: AnswerRepository, private val emailService: EmailService) :
    AnswerService {
    override fun save(answer: Answer) {
        answerRepository.save(answer)
        emailService.notification(answer.topic.author.email)
    }
}