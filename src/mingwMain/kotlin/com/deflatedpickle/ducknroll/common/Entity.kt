package com.deflatedpickle.ducknroll.common

import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.property.StringProperty

open class Entity(name: String) : PropertyHolder() {
    init {
        this.putProperty("name", StringProperty(name))
    }
}