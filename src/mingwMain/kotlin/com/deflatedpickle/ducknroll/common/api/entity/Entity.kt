package com.deflatedpickle.ducknroll.common.api.entity

import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.property.StringProperty
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

abstract class Entity(name: String) : PropertyHolder(), IUpdate {
    init {
        this.putProperty(CommonProperties.NAME, StringProperty(name))
    }
}