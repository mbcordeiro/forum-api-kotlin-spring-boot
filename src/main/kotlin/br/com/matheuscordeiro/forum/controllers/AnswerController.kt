package br.com.matheuscordeiro.forum.controllers

import br.com.matheuscordeiro.forum.models.Answer
import br.com.matheuscordeiro.forum.services.AnswerService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/answers")
@SecurityRequirement(name = "bearerAuth")
class AnswerController(private val answerService: AnswerService) {
    @PostMapping
    fun save(@RequestBody @Valid answer: Answer) {
        answerService.save(answer)
    }
}