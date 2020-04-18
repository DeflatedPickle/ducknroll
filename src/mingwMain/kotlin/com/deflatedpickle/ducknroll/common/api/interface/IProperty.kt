package com.deflatedpickle.ducknroll.common.api.`interface`

interface IProperty<T> {
    fun getValue(): T
    fun setValue(value: T)
}