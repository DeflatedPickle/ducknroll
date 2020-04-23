package com.deflatedpickle.ducknroll.common.api.stack

interface IStack<T> {
    fun getStackLength(): Int = 8

    fun push(index: Int, value: T): T
    fun pushBack(value: T): T = this.push(-1, value)

    fun pop(index: Int): T
    fun popFront(): T = this.pop(0)
}