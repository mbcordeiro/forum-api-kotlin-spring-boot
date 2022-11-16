package br.com.matheuscordeiro.forum.controllers

import br.com.matheuscordeiro.forum.dto.TopicByCategoryDto
import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.requests.UpdateTopicRequest
import br.com.matheuscordeiro.forum.responses.TopicResponse
import br.com.matheuscordeiro.forum.services.TopicService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearerAuth")
class TopicController(private val topicService: TopicService) {
    @GetMapping
    fun getList(
        @RequestParam(required = false) nameCourse: String?,
        @PageableDefault(size = 10, sort = ["dateCreation"], direction = Sort.Direction.DESC) pageable: Pageable
    ): Page<TopicResponse> {
        return topicService.findList(nameCourse, pageable)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicResponse {
        return topicService.findById(id)
    }

    @GetMapping("/report")
    fun report(): List<TopicByCategoryDto> {
        return topicService.reportByCategory()
    }

    @PostMapping
    fun create(
        @RequestBody @Valid newTopicRequest: NewTopicRequest,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicResponse> {
        val topic = topicService.insert(newTopicRequest)
        val uri = uriComponentsBuilder.path("/topics/${topic.id}").build().toUri()
        return ResponseEntity.created(uri).body(topic)
    }

    @PutMapping
    fun update(@RequestBody @Valid updateTopicRequest: UpdateTopicRequest): ResponseEntity<TopicResponse> {
        return ResponseEntity.ok(topicService.update(updateTopicRequest))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }
}