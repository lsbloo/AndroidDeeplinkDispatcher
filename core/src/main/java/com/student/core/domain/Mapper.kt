package com.student.core.domain

interface Mapper<I, O> {
    fun map(input: I): O
}