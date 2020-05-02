package com.deflatedpickle.ducknroll.common.area

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.matrix.ListMatrix
import com.deflatedpickle.ducknroll.common.api.matrix.Matrix
import com.deflatedpickle.ducknroll.common.api.matrix.MutableMatrix
import com.deflatedpickle.ducknroll.common.api.property.IntProperty
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.MatrixProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.spot.Spot

// TODO: Add a time offset for areas
class Area(width: Int, height: Int) : PropertyHolder() {
    init {
        // Unlike dimension areas being nullable, spots aren't
        // This is because a spot can have an AIR tile
        this.putProperty(
            CommonProperties.SPOT,
            MatrixProperty(ListMatrix(width, height) { _: Int, _: Int -> Spot() })
        )
    }

    fun spawn(entity: Object, x: Int = 0, y: Int = 0) {
        this.getProperty<MutableMatrix<Spot>>(
            CommonProperties.SPOT
        ).getValue()[x, y].getProperty<MutableList<Object>>(
            CommonProperties.OBJECT
        ).getValue().add(entity)
    }
}