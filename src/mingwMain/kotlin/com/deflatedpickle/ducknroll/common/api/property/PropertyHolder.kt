package com.deflatedpickle.ducknroll.common.api.property

abstract class PropertyHolder {
    protected val propertyList = mutableMapOf<String, IProperty<*>>()

    /**
     * Checks if a property attached to the key exists
     */
    fun hasProperty(key: String): Boolean = propertyList.containsKey(key)

    /**
     * Returns a property cast to the given generic
     */
    fun <T> getProperty(key: String): IProperty<T> = propertyList[key] as IProperty<T>

    /**
     * Returns a property cast to a compound property
     */
    fun <T> getCompoundProperty(key: String): CompoundProperty<T> = propertyList[key] as CompoundProperty<T>

    /**
     * Returns all the properties
     */
    fun <T> getAllProperties(): Map<String, IProperty<T>> = propertyList.mapValues { it.value as IProperty<T> }

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

    fun <T> putCompoundProperty(key: String, property: IProperty<T>): CompoundProperty<T> = putProperty(key, property) as CompoundProperty<T>

    /**
     * Removes all properties
     */
    fun clearProperties() {
        this.propertyList.clear()
    }
}