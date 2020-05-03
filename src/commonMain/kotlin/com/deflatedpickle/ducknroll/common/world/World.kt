package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.clock.UpdateClock
import com.deflatedpickle.ducknroll.common.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.ReferenceProperty
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.area.Area

class World : Object() {
    var clock: UpdateClock<Object>? = null

    init {
        this.putProperty(CommonProperties.DIMENSION,
            ListProperty<Dimension>()
        )
    }

    fun addDimension(dimension: Dimension) {
        this.getFirstPropertyOfType<MutableList<Dimension>>().getValue().add(dimension)
        dimension.putProperty(CommonProperties.WORLD, ReferenceProperty(this))
    }
}