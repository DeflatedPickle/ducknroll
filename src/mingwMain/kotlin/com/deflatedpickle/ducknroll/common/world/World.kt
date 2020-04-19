package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.entity.Entity
import com.deflatedpickle.ducknroll.common.api.clock.StepClock
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

class World : PropertyHolder() {
    val clock = StepClock()

    fun spawn(entity: Entity) {
        this.clock
    }
}