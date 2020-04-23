package com.deflatedpickle.ducknroll.common.api.various

interface ICreated<T> {
    fun create(arguments: List<Any>): T
}