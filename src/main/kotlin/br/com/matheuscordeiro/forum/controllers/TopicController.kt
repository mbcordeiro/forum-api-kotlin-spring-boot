package br.com.matheuscordeiro.forum.controllers

import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {
    @GetMapping
    fun getList(): List<TopicResponse> {
        return topicService.findList()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicResponse {
        return topicService.findById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid newTopicRequest: NewTopicRequest) {
        topicService.insert(newTopicRequest)
    }
}