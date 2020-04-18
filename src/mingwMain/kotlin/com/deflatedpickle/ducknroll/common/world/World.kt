package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.Entity
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

class World : PropertyHolder() {
    val clock = WorldClock()
    val entities = mutableListOf<Entity>()
}