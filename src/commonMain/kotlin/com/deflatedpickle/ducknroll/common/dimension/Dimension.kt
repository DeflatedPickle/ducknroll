package com.deflatedpickle.ducknroll.common.dimension

import com.deflatedpickle.ducknroll.common.api.matrix.ListMatrix
import com.deflatedpickle.ducknroll.common.api.matrix.MutableListMatrix
import com.deflatedpickle.ducknroll.common.area.Area
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.MatrixProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.property.ReferenceProperty
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.world.World

// TODO: Add a time offset for dimensions
class Dimension(width: Int, height: Int) : PropertyHolder() {
    init {
        // Areas are null as a map of the specified size is needed
        // But the user might not want a rectangular map
        this.putProperty(
            CommonProperties.AREA,
            MatrixProperty<Area?>(ListMatrix(width, height) { _: Int, _: Int -> null })
        )
    }

    fun getWorld(): World = this.getProperty<World>(CommonProperties.WORLD).getValue()

    fun addArea(area: Area, x: Int, y: Int) {
        this.getProperty<MutableListMatrix<Area>>(CommonProperties.AREA).getValue()[x, y] = area
        area.putProperty(CommonProperties.DIMENSION, ReferenceProperty(this))
    }
}