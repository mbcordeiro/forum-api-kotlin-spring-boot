package br.com.matheuscordeiro.forum.service

import br.com.matheuscordeiro.forum.mappers.TopicRequestMapper
import br.com.matheuscordeiro.forum.mappers.TopicResponseMapper
import br.com.matheuscordeiro.forum.model.TopicResponseTest
import br.com.matheuscordeiro.forum.model.TopicTest
import br.com.matheuscordeiro.forum.models.Topic
import br.com.matheuscordeiro.forum.repositories.TopicRepository
import br.com.matheuscordeiro.forum.services.impl.TopicServiceImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TopicServiceTest {
    private val topic = TopicTest.build()
    private val topicResponse = TopicResponseTest.build()
    private val pages = PageImpl(listOf(topic))
    private val pageable: Pageable = mockk()
    private val topicRepository: TopicRepository = mockk {
        every { findAll(pageable) } returns pages
        every { findByCourseName(any(), any()) } returns pages
    }
    private val topicResponseMapper: TopicResponseMapper = mockk()
    private val topicRequestMapper: TopicRequestMapper = mockk()
    private val topicServiceImpl = TopicServiceImpl(topicRepository, topicResponseMapper, topicRequestMapper)

    @Test
    fun `should list topic by course name`() {
        val slot = slot<Topic>()
        every { topicResponseMapper.map(capture(slot)) } returns topicResponse
        topicServiceImpl.findList("Kotlin Basic", pageable);

        verify(exactly = 0) { topicRepository.findAll(pageable) }
        verify(exactly = 1) { topicRepository.findByCourseName(any(), any()) }
        verify(exactly = 1) { topicResponseMapper.map(any()) }

        assertThat(slot.captured.tittle).isEqualTo(topic.tittle)
        assertThat(slot.captured.message).isEqualTo(topic.message)
        assertThat(slot.captured.status).isEqualTo(topic.status)
    }

    @Test
    fun `should list all topics when course name is null`() {
        val slot = slot<Topic>()
        every { topicResponseMapper.map(capture(slot)) } returns topicResponse
        topicServiceImpl.findList(null, pageable)

        verify(exactly = 0) { topicRepository.findAll(pageable) }
        verify(exactly = 1) { topicRepository.findByCourseName(any(), any()) }
        verify(exactly = 1) { topicResponseMapper.map(any()) }

        assertThat(slot.captured.tittle).isEqualTo(topic.tittle)
        assertThat(slot.captured.message).isEqualTo(topic.message)
        assertThat(slot.captured.status).isEqualTo(topic.status)
    }
}