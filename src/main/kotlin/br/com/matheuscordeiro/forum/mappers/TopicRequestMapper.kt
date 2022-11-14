package br.com.matheuscordeiro.forum.mappers

import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.requests.NewTopicRequest
import br.com.matheuscordeiro.forum.services.CourseService
import br.com.matheuscordeiro.forum.services.UserService
import java.time.LocalDate

class TopicRequestMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<NewTopicRequest, Topic> {
    override fun map(t: NewTopicRequest): Topic {
        return Topic(
            tittle = t.title,
            message = t.message,
            course = courseService.findById(t.idCourse),
            author = userService.findById(t.idAuthor),
            dateUpdate = LocalDate.now()
        )
    }

}
