package com.deflatedpickle.ducknroll.common.api.matrix

class MutableListMatrix<T>(
    columns: Int,
    rows: Int,
    init: (Int, Int) -> T
) : ListMatrix<T>(columns, rows, init), MutableMatrix<T> {
    override fun iterator(): MutableIterator<T> = this.list.iterator()

    override fun add(element: T): Boolean = this.list.add(element)

    override fun addAll(elements: Collection<T>): Boolean = this.list.addAll(elements)

    override fun clear() = this.list.clear()

    override fun remove(element: T): Boolean = this.list.remove(element)

    override fun removeAll(elements: Collection<T>): Boolean = this.list.removeAll(elements)

    override fun retainAll(elements: Collection<T>): Boolean = this.list.retainAll(elements)
}