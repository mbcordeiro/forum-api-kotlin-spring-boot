package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.dtos.NewTopicDto
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
    override fun findList(): List<Topic> {
        return topics
    }

    override fun findById(id: Long): Topic {
        return topics.first {
            it.id == id
        }
    }

    override fun insert(newTopicDto: NewTopicDto) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                tittle = newTopicDto.title,
                message = newTopicDto.message,
                course = courseService.findById(newTopicDto.idCourse),
                author = userService.findById(newTopicDto.idAuthor)
            )
        )
    }
}