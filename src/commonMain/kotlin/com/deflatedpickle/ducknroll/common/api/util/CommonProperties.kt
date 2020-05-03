package com.deflatedpickle.ducknroll.common.api.util

import com.deflatedpickle.ducknroll.common.area.Area
import com.deflatedpickle.ducknroll.common.api.clock.AbstractClock
import com.deflatedpickle.ducknroll.common.clock.StepTickClock
import com.deflatedpickle.ducknroll.common.dimension.Dimension
import com.deflatedpickle.ducknroll.common.api.spot.TileType
import com.deflatedpickle.ducknroll.common.spot.Spot
import com.deflatedpickle.ducknroll.common.world.World

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
     * The inventory of an object
     * Type: [List]
     */
    INVENTORY("inventory"),

    /**
     * The type of a tile
     * Type: [TileType]
     */
    TILE_TYPE("type"),

    /**
     * The world of a dimension
     * Type: [World]
     */
    WORLD("world"),

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
     * The spots in an [Area]
     * Type: [IObject]
     */
    SPOT("spot"),

    /**
     * The objects in a [Spot]
     * Type: [List]
     */
    OBJECT("object"),

    /**
     * The width of an object
     * Type: [Int]
     */
    WIDTH("width"),

    /**
     * The height of an object
     * Type: [Int]
     */
    HEIGHT("height"),

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