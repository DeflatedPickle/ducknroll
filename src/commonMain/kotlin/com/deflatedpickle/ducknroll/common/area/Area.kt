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
        this.putProperty(
            CommonProperties.SPOT,
            MatrixProperty(ListMatrix(width, height) { _: Int, _: Int -> Spot() })
        )
        this.putProperty(CommonProperties.WIDTH, IntProperty(width))
        this.putProperty(CommonProperties.HEIGHT, IntProperty(height))
    }

    fun spawn(entity: Object, x: Int = 0, y: Int = 0) {
        this.getProperty<MutableMatrix<Spot>>(
            CommonProperties.SPOT
        ).getValue()[x, y].getProperty<MutableList<Object>>(
            CommonProperties.OBJECT
        ).getValue().add(entity)
    }
}