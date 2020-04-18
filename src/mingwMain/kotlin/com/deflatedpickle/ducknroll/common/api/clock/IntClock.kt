package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.abstract.AbstractClock
import com.deflatedpickle.ducknroll.common.api.property.BooleanProperty

open class IntClock(interval: Int) : AbstractClock<Int>(interval) {
    override fun run() {
    }

    override fun progress() {
    }
}