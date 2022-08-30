package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.models.User
import br.com.matheuscordeiro.forum.repositories.UserRepository
import br.com.matheuscordeiro.forum.services.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun findById(id: Long): User {
        return userRepository.getReferenceById(id)
    }
}