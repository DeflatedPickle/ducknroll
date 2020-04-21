package com.deflatedpickle.ducknroll.common.api.dimension

import com.deflatedpickle.ducknroll.common.api.area.Area
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

// TODO: Add a time offset for dimensions
class Dimension : PropertyHolder() {
    init {
        this.putProperty(CommonProperties.AREA, ListProperty<Area>())
    }
}