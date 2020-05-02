package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.clock.UpdateClock
import com.deflatedpickle.ducknroll.common.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

class World : Object() {
    var clock: UpdateClock<Object>? = null

    init {
        this.putProperty(CommonProperties.DIMENSION,
            ListProperty<Dimension>()
        )
    }
}