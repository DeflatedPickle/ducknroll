package com.deflatedpickle.ducknroll.common.common.entity

import com.deflatedpickle.ducknroll.common.api.entity.Entity
import com.deflatedpickle.ducknroll.common.api.property.IntProperty
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

class Player(name: String) : Entity(name) {
    init {
        this.putProperty(CommonProperties.LEVEL, IntProperty())
        this.putProperty(CommonProperties.EXPERIENCE, IntProperty())
        // this.putProperty("title", ListProperty<>())
    }
}