package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.models.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun findById(id: Long): User
}
