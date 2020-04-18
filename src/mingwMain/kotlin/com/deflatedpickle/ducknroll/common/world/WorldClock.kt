package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.clock.FloatClock
import com.deflatedpickle.ducknroll.common.api.property.IntProperty
import kotlin.system.getTimeMillis

class WorldClock : FloatClock(1 / 60f) {
    init {
        // TODO: Create a compound property
        this.putProperty("hour", IntProperty(0))
        this.putProperty("minute", IntProperty(0))
        this.putProperty("second", IntProperty(0))
    }

    override fun run() {
        var lastFrame = getTimeMillis()

        while (this.getProperty<Boolean>("run").getValue()) {
            val currentFrame = getTimeMillis()
            val deltaTime = currentFrame - lastFrame
            lastFrame = deltaTime

            this.update(deltaTime.toFloat())
        }
    }

    fun increaseTime() {
        val second = this.getProperty<Int>("second")
        val minute = this.getProperty<Int>("minute")
        val hour = this.getProperty<Int>("hour")

        if (hour.getValue() < 24) {
            if (minute.getValue() <= 60) {
                if (second.getValue() < 60) {
                    second.setValue(second.getValue() + 1)
                }
                else {
                    second.setValue(0)
                    minute.setValue(minute.getValue() + 1)
                }
            }
            else {
                minute.setValue(0)
                hour.setValue(hour.getValue() + 1)
            }
        }
    }
}