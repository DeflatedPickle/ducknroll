package com.deflatedpickle.ducknroll.common.api.util

import kotlin.reflect.KClass

import com.deflatedpickle.ducknroll.common.api.clock.AbstractClock
import com.deflatedpickle.ducknroll.common.api.clock.TickClock

/**
 * An enum of commonly used properties
 */
enum class CommonProperties(val key: String, val valueType: KClass<*>) {
    /**
     * The name of an object
     */
    NAME("name", String::class),

    /**
     * The level of an object
     */
    LEVEL("level", Int::class),

    /**
     * The experience an object has towards the next level
     */
    EXPERIENCE("experience", Int::class),

    /**
     * The running state of an object
     *
     * @sample AbstractClock.start
     */
    RUNNING("running", Boolean::class),

    /**
     * The finished state of an object
     *
     * @sample TickClock.run
     */
    FINISHED("finished", Boolean::class)
}