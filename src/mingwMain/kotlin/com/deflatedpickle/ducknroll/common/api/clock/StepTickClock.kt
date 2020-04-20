package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

/**
 * A clock based on real-time ticks
 */
open class StepTickClock<T : IUpdate>(
        /**
         * This callback is called constantly
         */
        val constantCallback: (clock: StepTickClock<T>) -> Unit = {},
        /**
         * This callback is called when the [getCurrentTicks] is different
         */
        val updateCallback: (clock: StepTickClock<T>) -> Unit = {
            it.tick()
        }
) : UpdateClock<T>(), IRun {
    private var lastTicks = 0
    private var currentTicks = 0

    fun getCurrentTicks(): Int = this.currentTicks
    fun getDeltaTime(): Int = this.currentTicks - this.lastTicks

    override fun start() {
        super.start()

        this.run()
    }

    override fun run() {
        while (!this.getPropertyValue<Boolean>(CommonProperties.FINISHED)) {
            this.constantCallback(this)

            for (i in this.lastTicks until this.currentTicks) {
                this.updateCallback(this)
            }
            this.lastTicks = this.currentTicks
        }
        this.getProperty<Boolean>(CommonProperties.FINISHED).setValue(true)
    }

    /**
     * Steps the clock by the given amount
     */
    fun step(ticks: Int) {
        this.currentTicks += ticks
    }
}