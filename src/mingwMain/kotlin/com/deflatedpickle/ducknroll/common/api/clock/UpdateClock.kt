package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.area.Area
import com.deflatedpickle.ducknroll.common.api.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.various.IUpdate
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.api.various.ICatchup
import com.deflatedpickle.ducknroll.common.world.World

/**
 * An implementation of [AbstractClock] that will update when ticked
 */
open class UpdateClock<T : Object>(val world: World) : AbstractClock<T>(), ICatchup {
    override fun update() {
        for (dimension in this.world.getProperty<List<Dimension>>(CommonProperties.DIMENSION).getValue()) {
            for (area in dimension.getProperty<List<Area>>(CommonProperties.AREA).getValue()) {
                // Heh... objeKT
                for (objekt in area.getProperty<List<Object>>(CommonProperties.OBJECT).getValue()) {
                    objekt.update()
                }
            }
        }

        for (component in this.world.getAllComponents()) {
            component.update()
        }
    }

    override fun catchup() {
        for (dimension in this.world.getProperty<List<Dimension>>(CommonProperties.DIMENSION).getValue()) {
            for (area in dimension.getProperty<List<Area>>(CommonProperties.AREA).getValue()) {
                // Heh... objeKT
                for (objekt in area.getProperty<List<Object>>(CommonProperties.OBJECT).getValue()) {
                    objekt.catchup()
                }
            }
        }

        for (component in this.world.getAllComponents()) {
            component.catchup()
        }
    }
}