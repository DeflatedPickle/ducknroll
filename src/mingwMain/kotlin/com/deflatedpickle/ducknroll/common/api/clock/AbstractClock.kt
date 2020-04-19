package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.BooleanProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder

abstract class AbstractClock<T : Number, O : IUpdate> : PropertyHolder(),
    IClock<T, O> {
    private val iUpdateList = mutableListOf<O>()

    init {
        this.putProperty("run", BooleanProperty())
    }

    override fun start() {
        this.getProperty<Boolean>("run").setValue(true)

        this.run()
    }

    override fun run() {
        while (this.getProperty<Boolean>("run").getValue()) {
            tick()
        }
    }

    override fun tick() {
        for (iUpdate in this.iUpdateList) {
            iUpdate.preUpdate()
            iUpdate.update()
            iUpdate.postUpdate()
        }
    }

    override fun addObject(obj: O) {
        this.iUpdateList.add(obj)
    }
}