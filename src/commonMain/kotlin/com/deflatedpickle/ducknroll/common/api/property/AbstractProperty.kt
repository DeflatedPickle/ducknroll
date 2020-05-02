package com.deflatedpickle.ducknroll.common.api.property

abstract class AbstractProperty<T>(private var value: T) :
    IProperty<T> {
    override fun getValue(): T = this.value

    override fun setValue(value: T) {
        this.value = value
    }

    override fun toString(): String = this.value.toString()
}