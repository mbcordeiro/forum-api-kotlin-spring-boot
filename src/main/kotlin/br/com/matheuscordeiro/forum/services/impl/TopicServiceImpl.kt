package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.request.NewTopicRequest
import br.com.matheuscordeiro.forum.response.TopicResponse
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.services.UserService
import br.com.matheuscordeiro.forum.services.CourseService
import br.com.matheuscordeiro.forum.services.TopicService
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private var topics: List<Topic>,
    private val courseService: CourseService,
    private val userService: UserService
) : TopicService {
    override fun findList(): List<TopicResponse> {
        return topics.map {
            TopicResponse(
                id = it.id,
                title = it.tittle,
                message = it.message,
                dateCreation = it.dateCreation,
                status = it.status
            )
        }
    }

    override fun findById(id: Long): TopicResponse {
        val topic = topics.first {
            it.id == id
        }

        return TopicResponse(
            id = topic.id,
            title = topic.tittle,
            message = topic.message,
            dateCreation = topic.dateCreation,
            status = topic.status
        )
    }

    override fun insert(newTopicRequest: NewTopicRequest) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                tittle = newTopicRequest.title,
                message = newTopicRequest.message,
                course = courseService.findById(newTopicRequest.idCourse),
                author = userService.findById(newTopicRequest.idAuthor)
            )
        )
    }
}