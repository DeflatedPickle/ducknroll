package com.deflatedpickle.ducknroll.common.clock

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.api.various.IRun
import com.deflatedpickle.ducknroll.common.world.World

/**
 * A clock based on real-time ticks
 */
open class StepTickClock<T : Object>(
    world: World,
    /**
         * This callback is called constantly
         */
        val updateCallback: (clock: StepTickClock<T>) -> Unit = {
            it.update()
        },
    /**
         * This update is called until [lastTicks] matches [getCurrentTicks]
         */
        val catchupCallback: (clock: StepTickClock<T>) -> Unit = {
            it.catchup()
        }
) : UpdateClock<T>(world),
    IRun {
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
            this.updateCallback(this)

            for (i in this.lastTicks until this.currentTicks) {
                this.catchupCallback(this)
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