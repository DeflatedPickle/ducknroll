package com.deflatedpickle.ducknroll.common.world

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.component.IComponent
import com.deflatedpickle.ducknroll.common.api.various.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.CompoundProperty
import com.deflatedpickle.ducknroll.common.api.property.IntProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

/**
 * A clock to store the time and date of a world
 */
class WorldTimeDate : PropertyHolder(), IComponent {
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

    fun getTime(): String {
        val time = this.getCompoundProperty<Int>("time")

        val second = time.getProperty<Int>("second")
        val minute = time.getProperty<Int>("minute")
        val hour = time.getProperty<Int>("hour")

        return "${hour.getValue()}:${minute.getValue()}:${second.getValue()}"
    }

    private fun increaseTime() {
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
    }

    override fun update() {
    }

    override fun catchup() {
        this.increaseTime()
    }
}