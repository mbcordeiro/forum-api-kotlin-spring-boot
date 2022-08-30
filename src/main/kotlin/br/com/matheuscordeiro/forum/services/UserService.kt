package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.models.User

interface UserService {
    fun findById(id: Long): User
}
