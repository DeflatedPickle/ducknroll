package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.various.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.BooleanProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

abstract class AbstractClock<T : IUpdate> : PropertyHolder(), IClock<T> {
    init {
        /**
         * Whether or not the clock is currently running
         * true: it is
         * false: it's paused
         */
        this.putProperty("running", BooleanProperty())
        /**
         * Whether or not the clock is finished
         * true: it is
         * false: it's running or paused
         */
        this.putProperty("finished", BooleanProperty())
    }

    override fun start() {
        this.getProperty<Boolean>("running").setValue(true)
    }
}