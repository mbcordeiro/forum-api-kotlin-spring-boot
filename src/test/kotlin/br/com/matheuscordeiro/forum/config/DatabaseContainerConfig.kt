package br.com.matheuscordeiro.forum.config

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DatabaseContainerConfig {
    companion object {
        @Container
        private val postgresqlContainer = PostgreSQLContainer<Nothing>("postgresql:latest").apply {
            withDatabaseName("testdb")
            withUsername("test")
            withPassword("12345")
        }

        @Container
        private val redisContainer = GenericContainer<Nothing>("redis:latest").apply {
            withExposedPorts(6379)
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
            registry.add("spring.datasource.password", postgresqlContainer::getPassword);
            registry.add("spring.datasource.username", postgresqlContainer::getUsername);
            registry.add("spring.redis.host", redisContainer::getContainerIpAddress)
            registry.add("spring.redis.port", redisContainer::getFirstMappedPort)
        }
    }

}