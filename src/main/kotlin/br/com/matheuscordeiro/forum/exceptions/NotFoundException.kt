package br.com.matheuscordeiro.forum.exceptions

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}