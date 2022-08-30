package br.com.matheuscordeiro.forum.mappers

interface Mapper<T, U> {
    fun map(t: T): U
}