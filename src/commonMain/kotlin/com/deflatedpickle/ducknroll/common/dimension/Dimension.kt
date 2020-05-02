package com.deflatedpickle.ducknroll.common.dimension

import com.deflatedpickle.ducknroll.common.api.matrix.ListMatrix
import com.deflatedpickle.ducknroll.common.area.Area
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.MatrixProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

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
}