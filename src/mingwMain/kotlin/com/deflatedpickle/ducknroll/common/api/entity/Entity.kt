package com.deflatedpickle.ducknroll.common.api.entity

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.property.StringProperty
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.api.various.IUpdate

abstract class Entity(name: String) : Object(), IUpdate {
    init {
        this.putProperty(CommonProperties.NAME, StringProperty(name))
    }
}