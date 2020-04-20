package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.entity.IUpdate

/**
 * An implementation of [AbstractClock] that will update when ticked
 */
open class UpdateClock<T : IUpdate> : AbstractClock<T>() {
    private val iUpdateList = mutableListOf<T>()

    override fun tick() {
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