package br.com.matheuscordeiro.forum.repositories

import br.com.matheuscordeiro.forum.models.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(username: String?): User?

}