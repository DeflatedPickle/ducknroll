package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.CompoundProperty
import com.deflatedpickle.ducknroll.common.api.property.IntProperty

/**
 * An implementation of [IClock] that will update when stepped
 */
class StepClock : FloatClock<IUpdate>() {
    init {
        with(this.putCompoundProperty("time", CompoundProperty<Any>())) {
            this.putProperty("second", IntProperty(0))
            this.putProperty("minute", IntProperty(0))
            this.putProperty("hour", IntProperty(0))
        }

        with(this.putCompoundProperty("date", CompoundProperty<Any>())) {
            this.putProperty("day", IntProperty(0))
            this.putProperty("month", IntProperty(0))
            this.putProperty("year", IntProperty(0))
        }
    }

    fun increaseTime() {
        val second = this.getCompoundProperty<Int>("time").getProperty<Int>("second")
        val minute = this.getCompoundProperty<Int>("time").getProperty<Int>("minute")
        val hour = this.getCompoundProperty<Int>("time").getProperty<Int>("hour")

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

        println("${hour.getValue()}:${minute.getValue()}:${second.getValue()}")
    }
}