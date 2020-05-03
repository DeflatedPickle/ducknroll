package com.deflatedpickle.ducknroll.common.spot

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.property.EnumProperty
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.spot.TileType
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.area.Area

/**
 * A spot is a cell in the map matrix. It contains a tile type, items and entities
 */
class Spot : PropertyHolder() {
    init {
        this.putProperty(CommonProperties.TILE_TYPE, EnumProperty(TileType.AIR))
        this.putProperty(CommonProperties.OBJECT, ListProperty<Object>())
    }

    fun getArea(): Area = this.getProperty<Area>(CommonProperties.AREA).getValue()
}