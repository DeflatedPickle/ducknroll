package com.deflatedpickle.ducknroll.common.api.entity

import com.deflatedpickle.ducknroll.common.api.property.IntProperty
import com.deflatedpickle.ducknroll.common.api.property.ListProperty

class Player(name: String) : Entity(name) {
    init {
        this.putProperty("level", IntProperty())
        this.putProperty("experience", IntProperty())
        // this.putProperty("title", ListProperty<>())
    }
}