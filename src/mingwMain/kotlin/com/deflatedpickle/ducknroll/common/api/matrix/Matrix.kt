package com.deflatedpickle.ducknroll.common.api.matrix

/**
 * Essentially a list, wrapped to the width, with helper functions to get the surrounding cells
 */
interface Matrix<T> : Collection<T> {
    val columns: Int
    val rows: Int

    override val size: Int
        get() = this.columns * this.rows

    operator fun get(x: Int, y: Int): T
}