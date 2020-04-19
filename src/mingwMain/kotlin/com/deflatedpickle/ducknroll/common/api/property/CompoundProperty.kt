package com.deflatedpickle.ducknroll.common.api.property

class CompoundProperty<T> : PropertyHolder(),
    IProperty<Map<String, IProperty<T>>> {
    fun getValue(key: String): IProperty<T>? = this.getValue()[key]

    override fun getValue(): Map<String, IProperty<T>> = this.propertyList as Map<String, IProperty<T>>

    fun setValue(key: String, value: IProperty<T>) {
        this.propertyList[key] = value
    }

    override fun setValue(value: Map<String, IProperty<T>>) {
        this.propertyList.clear()
        this.propertyList.putAll(value)
    }
}