package com.deflatedpickle.ducknroll.common.api.stack

interface IHasStack<T> {
    fun getStack(): IStack<T>
}