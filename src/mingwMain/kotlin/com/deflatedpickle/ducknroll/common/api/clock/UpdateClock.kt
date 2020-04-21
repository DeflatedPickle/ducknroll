package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.`object`.IObject
import com.deflatedpickle.ducknroll.common.api.area.Area
import com.deflatedpickle.ducknroll.common.api.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.world.World

/**
 * An implementation of [AbstractClock] that will update when ticked
 */
open class UpdateClock<T : IUpdate>(val world: World) : AbstractClock<T>() {
    private val iUpdateList = mutableListOf<T>()

    override fun tick() {
        for (dimension in this.world.getProperty<List<Dimension>>(CommonProperties.DIMENSION).getValue()) {
            for (area in dimension.getProperty<List<Area>>(CommonProperties.AREA).getValue()) {
                // Heh... objeKT
                for (objekt in area.getProperty<List<IObject>>(CommonProperties.OBJECT).getValue()) {
                    if (objekt is IUpdate) {
                        objekt.preUpdate()
                        objekt.update()
                        objekt.postUpdate()
                    }
                }
            }
        }

        for (iUpdate in this.iUpdateList) {
            iUpdate.preUpdate()
            iUpdate.update()
            iUpdate.postUpdate()
        }
    }

    fun addObject(obj: T) {
        this.iUpdateList.add(obj)
    }

    fun getObject(index: Int): T =
            this.iUpdateList[index]

    fun getAllObjects(): List<T> = this.iUpdateList
}