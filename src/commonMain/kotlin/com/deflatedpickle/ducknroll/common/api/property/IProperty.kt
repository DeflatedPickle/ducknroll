package com.deflatedpickle.ducknroll.common.api.property

interface IProperty<T> {
    fun getValue(): T
    fun setValue(value: T)
}