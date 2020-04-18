package com.deflatedpickle.ducknroll.common.api.property

import com.deflatedpickle.ducknroll.common.api.`interface`.IProperty

abstract class PropertyHolder {
    private val propertyList = mutableMapOf<String, IProperty<*>>()

    /**
     * Checks if a property attached to the key exists
     */
    fun hasProperty(key: String): Boolean = propertyList.containsKey(key)

    /**
     * Returns a property cast to the given generic
     */
    fun <T> getProperty(key: String): IProperty<T> = propertyList[key] as IProperty<T>

    /**
     * Uses [hasProperty], returns [getProperty] if true, else null
     */
    fun <T> hasGetProperty(key: String): IProperty<T>? =
        if (this.hasProperty(key)) this.getProperty(key) else null

    /**
     * Stores a given property
     */
    fun <T> putProperty(key: String, property: IProperty<T>): IProperty<T> {
        this.propertyList[key] = property
        return property
    }

    /**
     * Removes all properties
     */
    fun clearProperties() {
        this.propertyList.clear()
    }
}