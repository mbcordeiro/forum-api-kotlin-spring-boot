package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.models.User
import br.com.matheuscordeiro.forum.services.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private var users: List<User>) : UserService {
    init {
        val user = User(id = 1, name = "Matheus Cordeiro", email = "email@email.com")
        users = listOf(user)
    }
    override fun findById(id: Long): User {
        return users.first {
            it.id == id
        }
    }
}