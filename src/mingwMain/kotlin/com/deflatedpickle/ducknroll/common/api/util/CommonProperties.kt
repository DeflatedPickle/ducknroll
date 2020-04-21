package com.deflatedpickle.ducknroll.common.api.util

import com.deflatedpickle.ducknroll.common.api.area.Area
import com.deflatedpickle.ducknroll.common.api.clock.AbstractClock
import com.deflatedpickle.ducknroll.common.api.clock.StepTickClock
import com.deflatedpickle.ducknroll.common.api.dimension.Dimension

/**
 * An enum of commonly used properties
 */
enum class CommonProperties(val key: String) {
    /**
     * The name of an object
     * Type: [String]
     */
    NAME("name"),

    /**
     * The level of an object
     * Type: [Int]
     */
    LEVEL("level"),

    /**
     * The experience an object has towards the next level
     * Type: [Int]
     */
    EXPERIENCE("experience"),

    /**
     * The dimensions of a world
     * Type: [Dimension]
     */
    DIMENSION("dimension"),

    /**
     * The areas of a dimension
     * Type: [Area]
     */
    AREA("area"),

    /**
     * The objects in an [Area]
     * Type: [IObject]
     */
    OBJECT("object"),

    /**
     * The running state of an object
     * Type: [Boolean]
     *
     * @sample AbstractClock.start
     */
    RUNNING("running"),

    /**
     * The finished state of an object
     * Type: [Boolean]
     *
     * @sample StepTickClock.run
     */
    FINISHED("finished")
}