package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.abstract.AbstractClock

open class FloatClock(interval: Float) : AbstractClock<Float>(interval) {
    override fun run() {
    }

    override fun progress() {
    }
}