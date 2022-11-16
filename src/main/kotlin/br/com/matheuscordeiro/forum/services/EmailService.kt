package br.com.matheuscordeiro.forum.services

import br.com.matheuscordeiro.forum.models.User


interface EmailService {
    fun notification(email: String)
}