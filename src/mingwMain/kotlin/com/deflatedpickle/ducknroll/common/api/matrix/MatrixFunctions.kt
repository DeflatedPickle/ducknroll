package com.deflatedpickle.ducknroll.common.api.matrix

inline fun <T> Matrix<T>.forEachIndexed(action: (Int, Int, T) -> Unit) {
    for (y in 0 until this.rows) {
        for (x in 0 until this.columns) {
            action(x, y, this[x, y])
        }
    }
}