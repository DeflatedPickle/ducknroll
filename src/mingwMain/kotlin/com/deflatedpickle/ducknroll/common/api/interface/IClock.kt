package com.deflatedpickle.ducknroll.common.api.`interface`

import kotlin.reflect.KClass

interface IClock {
    fun start()

    fun run()

    fun progress()

    fun update(deltaTime: Float, predicate: (KClass<Any>, IUpdate) -> Boolean)

    fun update(deltaTime: Float) {
        this.update(deltaTime) { _, _ -> true }
    }
}