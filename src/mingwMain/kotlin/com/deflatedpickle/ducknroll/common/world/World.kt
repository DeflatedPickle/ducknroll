package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.clock.UpdateClock
import com.deflatedpickle.ducknroll.common.api.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

class World : PropertyHolder() {
    var clock: UpdateClock<IUpdate>? = null
    val timeDate = WorldTimeDate()

    init {
        this.putProperty("dimension", ListProperty<Dimension>())
    }
}