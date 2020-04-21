package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.various.IUpdate
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.api.various.IRun
import com.deflatedpickle.ducknroll.common.world.World
import kotlin.system.getTimeNanos

/**
 * A clock based on real-time ticks
 */
class RealTimeTickClock<T : Object>(
        world: World,
        /**
         * The calling interval, in ticks
         */
        val interval: Int = 20,
        /**
         * This callback is constantly called, before the [updateCallback]
         */
        val constantCallback: (clock: RealTimeTickClock<T>) -> Unit = {},
        /**
         * This callback is called when the [getCurrentTicks] is different
         */
        val updateCallback: (clock: RealTimeTickClock<T>) -> Unit = {
            it.update()
        }
) : UpdateClock<T>(world), IRun {
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

            this.constantCallback(this)
            if (this.getProperty<Boolean>(CommonProperties.RUNNING).getValue()) {
                if (currentTicks != lastTicks) {
                    this.updateCallback(this)
                }
            }

            lastTime = currentTime
            lastTicks = currentTicks
        }
        this.getProperty<Boolean>(CommonProperties.FINISHED).setValue(true)
    }
}