package br.com.matheuscordeiro.forum.models

import br.com.matheuscordeiro.forum.models.enums.TopicStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "topic")
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var tittle: String,
    var message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: User,
    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.UNANSWERED,
    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList()
)