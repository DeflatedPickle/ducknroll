package com.deflatedpickle.ducknroll.common.common.world

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.common.clock.UpdateClock
import com.deflatedpickle.ducknroll.common.common.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.property.ListProperty

class World : Object() {
    var clock: UpdateClock<Object>? = null

    init {
        this.putProperty("dimension", ListProperty<Dimension>())
    }
}