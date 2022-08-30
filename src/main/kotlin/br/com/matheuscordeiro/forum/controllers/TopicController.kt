package br.com.matheuscordeiro.forum.controllers

import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.requests.UpdateTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun create(@RequestBody @Valid newTopicRequest: NewTopicRequest, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<TopicResponse> {
        val topic = topicService.insert(newTopicRequest)
        val uri = uriComponentsBuilder.path("/topics/${topic.id}").build().toUri()
        return ResponseEntity.created(uri).body(topic)
    }

    @PutMapping
    fun update(@RequestBody @Valid updateTopicRequest: UpdateTopicRequest) : ResponseEntity<TopicResponse>{
        return ResponseEntity.ok(topicService.update(updateTopicRequest))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }
}