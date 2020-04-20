package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.entity.IUpdate

/**
 * An implementation of [AbstractClock] that will update when ticked
 */
open class StepClock<T : IUpdate> : AbstractClock<T>() {
    override fun tick() {
        for (iUpdate in this.iUpdateList) {
            iUpdate.preUpdate()
            iUpdate.update()
            iUpdate.postUpdate()
        }
    }
}