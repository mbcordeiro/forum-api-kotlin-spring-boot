package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.services.EmailService
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(private val javaMailSender: JavaMailSender) : EmailService {
    override fun notification(email: String) {
        val message = SimpleMailMessage()
        message.setSubject("Forum - Topic Answered")
        message.setText("You received an answer to your question, let's check it out?")
        message.setTo(email)
        javaMailSender.send(message)
    }
}