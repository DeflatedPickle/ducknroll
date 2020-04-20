package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import kotlin.system.getTimeNanos

/**
 * A clock based on real-time ticks
 */
class TickClock<T : IUpdate>(val interval: Int = 20, val callback: () -> Boolean = { true }) : StepClock<T>(), IRun {
    private val _interval: Long = 1_000_000_000L / this.interval

    var lastTime = getTimeNanos()

    fun getCurrentTicks(): Long = this.lastTime / this._interval
    fun getDeltaTime(): Long = (getTimeNanos() - this.lastTime) / this._interval

    override fun start() {
        super.start()

        this.run()
    }

    override fun run() {
        var lastTicks = this.getCurrentTicks()

        while (!this.getPropertyValue<Boolean>(CommonProperties.FINISHED)) {
            val currentTime = getTimeNanos()
            val currentTicks = getCurrentTicks()

            if (this.getProperty<Boolean>(CommonProperties.RUNNING).getValue()) {
                if (currentTicks != lastTicks) {
                    this.tick()
                    callback()
                }
            }

            lastTime = currentTime
            lastTicks = currentTicks
        }
        this.getProperty<Boolean>(CommonProperties.FINISHED).setValue(true)
    }
}