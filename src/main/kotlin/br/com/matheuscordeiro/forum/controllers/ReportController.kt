package br.com.matheuscordeiro.forum.controllers

import br.com.matheuscordeiro.forum.dto.TopicByCategoryDto
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/reports")
class ReportController(private val topicService: TopicService) {
    @GetMapping
    fun reportByCategory(): List<TopicByCategoryDto> {
        return topicService.reportByCategory();
    }
}