package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.clock.AbstractClock
import com.deflatedpickle.ducknroll.common.api.clock.UpdateClock
import com.deflatedpickle.ducknroll.common.api.entity.Entity
import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

class World : PropertyHolder() {
    var clock: UpdateClock<IUpdate>? = null
    val timeDate = WorldTimeDate()

    fun spawn(entity: IUpdate) {
        this.clock?.addObject(entity)
    }
}