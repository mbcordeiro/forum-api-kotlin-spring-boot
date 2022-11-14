package br.com.matheuscordeiro.forum.mappers

import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.responses.TopicResponse
import org.springframework.stereotype.Component

@Component
class TopicResponseMapper() : Mapper<Topic, TopicResponse> {
    override fun map(t: Topic): TopicResponse {
        return TopicResponse(
            id = t.id,
            title = t.tittle,
            message = t.message,
            dateCreation = t.dateCreation,
            status = t.status,
            dateUpdate = t.dateUpdate
        )
    }
}
