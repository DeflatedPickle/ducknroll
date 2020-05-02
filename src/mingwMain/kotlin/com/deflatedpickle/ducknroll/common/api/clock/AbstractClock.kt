package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.various.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.BooleanProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

abstract class AbstractClock<T : IUpdate> : PropertyHolder(),
    IClock<T> {
    init {
        /**
         * Whether or not the clock is currently running
         * true: it is
         * false: it's paused
         */
        this.putProperty(CommonProperties.RUNNING, BooleanProperty())
        /**
         * Whether or not the clock is finished
         * true: it is
         * false: it's running or paused
         */
        this.putProperty(CommonProperties.FINISHED, BooleanProperty())
    }

    override fun start() {
        this.getProperty<Boolean>(CommonProperties.RUNNING).setValue(true)
    }
}