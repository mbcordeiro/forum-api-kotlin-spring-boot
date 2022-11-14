package br.com.matheuscordeiro.forum.model

import br.com.matheuscordeiro.forum.models.User

object UserTest {
    fun build() = User(id = 1, name = "Matheus", email = "matheus@gmail.com", password = "1234")
    fun buildToken() = User(id = 1, name = "Matheus", email = "matheus@gmail.com", password = "1234")
}