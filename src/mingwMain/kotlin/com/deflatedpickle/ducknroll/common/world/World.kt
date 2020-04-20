package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.clock.AbstractClock
import com.deflatedpickle.ducknroll.common.api.clock.IClock
import com.deflatedpickle.ducknroll.common.api.clock.StepClock
import com.deflatedpickle.ducknroll.common.api.clock.TickClock
import com.deflatedpickle.ducknroll.common.api.entity.Entity
import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

class World : PropertyHolder() {
    var clock: AbstractClock<IUpdate>? = null
    val timeDate = WorldTimeDate()

    fun spawn(entity: IUpdate) {
        this.clock?.addObject(entity)
    }
}