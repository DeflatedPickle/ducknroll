package com.deflatedpickle.ducknroll.common.api.matrix

interface MutableMatrix<T> : Matrix<T>, MutableCollection<T> {
    operator fun set(x: Int, y: Int, value: T)
}