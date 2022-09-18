package br.com.matheuscordeiro.forum.services.impl

import br.com.matheuscordeiro.forum.models.User
import br.com.matheuscordeiro.forum.repositories.UserRepository
import br.com.matheuscordeiro.forum.security.UserDetail
import br.com.matheuscordeiro.forum.services.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserDetailsService, UserService {
    override fun findById(id: Long): User {
        return userRepository.getReferenceById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(user)
    }
}