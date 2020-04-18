package com.deflatedpickle.ducknroll.common.api.property

import com.deflatedpickle.ducknroll.common.api.`interface`.IProperty

abstract class AbstractProperty<T>(private var value: T) : IProperty<T> {
    override fun getValue(): T = this.value

    override fun setValue(value: T) {
        this.value = value
    }
}