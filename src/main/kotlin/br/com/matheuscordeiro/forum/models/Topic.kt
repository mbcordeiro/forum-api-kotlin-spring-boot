package br.com.matheuscordeiro.forum.models

import br.com.matheuscordeiro.forum.models.enums.TopicStatus
import org.hibernate.Hibernate
import java.time.LocalDate
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
    var dateUpdate: LocalDate? = null,
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: User,
    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.UNANSWERED,
    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Topic

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , tittle = $tittle , message = $message ," +
                " dateCreation = $dateCreation , course = $course , author = $author , status = $status )"
    }
}