package br.com.matheuscordeiro.forum.integration

import br.com.matheuscordeiro.forum.dto.TopicByCategoryDto
import br.com.matheuscordeiro.forum.model.TopicTest
import br.com.matheuscordeiro.forum.repositories.TopicRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicRepositoryTest {
    @Autowired
    private lateinit var topicRepository: TopicRepository

    private val pageRequest = PageRequest.of(0, 5)
    private val topic = TopicTest.build()

    companion object {
        @Container
        private val postgresqlContainer = PostgreSQLContainer<Nothing>("postgresql:latest").apply {
            withDatabaseName("testdb")
            withUsername("test")
            withPassword("12345")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
            registry.add("spring.datasource.password", postgresqlContainer::getPassword);
            registry.add("spring.datasource.username", postgresqlContainer::getUsername);
        }
    }

    @Test
    fun `should generate report`() {
        topicRepository.save(topic)
        val report = topicRepository.reportByCategory();
        assertThat(report).isNotNull
        assertThat(report.first()).isExactlyInstanceOf(TopicByCategoryDto::class.java)
    }
}