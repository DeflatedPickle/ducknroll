package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.clock.UpdateClock
import com.deflatedpickle.ducknroll.common.api.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.various.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

class World : Object() {
    var clock: UpdateClock<Object>? = null

    init {
        this.putProperty("dimension", ListProperty<Dimension>())
    }
}