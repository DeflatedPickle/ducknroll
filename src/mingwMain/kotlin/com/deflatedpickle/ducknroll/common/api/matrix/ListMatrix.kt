package com.deflatedpickle.ducknroll.common.api.matrix

open class ListMatrix<T>(
    final override val columns: Int,
    final override val rows: Int,
    init: (Int, Int) -> T
) : Matrix<T> {
    protected val list = MutableList(this.rows * this.columns) {
        init(it / this.rows, it % this.columns)
    }

    override fun contains(element: T): Boolean = this.list.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean = this.list.containsAll(elements)

    override fun isEmpty(): Boolean = this.list.isEmpty()

    override fun iterator(): Iterator<T> = this.list.iterator()

    // Credit: https://github.com/yinpeng/kotlin-matrix/blob/master/src/main/kotlin/com/ichipsea/kotlin/matrix/Matrix.kt#L20
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append('[')

        forEachIndexed { x, y, value ->
            if (x == 0) {
                stringBuilder.append('[')
            }

            stringBuilder.append(value.toString())

            if (x == columns - 1) {
                stringBuilder.append(']')
                if (y < rows - 1) {
                    stringBuilder.append(", ")
                }
            } else {
                stringBuilder.append(", ")
            }
        }
        stringBuilder.append(']')

        return stringBuilder.toString()
    }

    override fun get(x: Int, y: Int): T = this.list[y * this.columns + x]
}