package com.deflatedpickle.ducknroll.common.api.abstract

import com.deflatedpickle.ducknroll.common.api.`interface`.IClock
import com.deflatedpickle.ducknroll.common.api.`interface`.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.BooleanProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import kotlin.reflect.KClass

abstract class AbstractClock<T : Number>(private val interval: Number) : PropertyHolder(), IClock {
    private val listIUpdate = mutableMapOf<KClass<Any>, List<IUpdate>>()

    init {
        this.putProperty("run", BooleanProperty())
    }

    fun getInterval(): T = this.interval as T

    override fun start() {
        this.getProperty<Boolean>("run").setValue(true)

        this.run()
    }

    override fun update(deltaTime: Float, predicate: (KClass<Any>, IUpdate) -> Boolean) {
        for ((klass, list) in this.listIUpdate) {
            for (iUpdate in list) {
                if (predicate(klass, iUpdate)) {
                    this.progress()
                    iUpdate.update(deltaTime)
                }
            }
        }
    }
}