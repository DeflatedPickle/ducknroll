package com.deflatedpickle.ducknroll.common.api.property

import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

abstract class PropertyHolder {
    protected val propertyList = mutableMapOf<String, IProperty<*>>()

    /**
     * Checks if a property attached to the key exists
     */
    fun hasProperty(key: String): Boolean =
            propertyList.containsKey(key)

    /**
     * Returns a property cast to the given generic
     */
    fun <T> getProperty(key: String): IProperty<T> =
            propertyList[key] as IProperty<T>

    /**
     * Returns a property cast to the given generic, using a common property
     */
    fun <T> getProperty(commonProperty: CommonProperties): IProperty<T> =
            this.getProperty(commonProperty.key)

    /**
     * Returns the value of a property cast to the given generic
     */
    fun <T> getPropertyValue(key: String): T =
            propertyList[key]?.getValue() as T

    /**
     * Returns the value of a property cast to the given generic, using a common property
     */
    fun <T> getPropertyValue(commonProperty: CommonProperties): T =
            propertyList[commonProperty.key]?.getValue() as T

    /**
     * Returns a property cast to a compound property
     */
    fun <T> getCompoundProperty(key: String): CompoundProperty<T> =
            propertyList[key] as CompoundProperty<T>

    /**
     * Returns all the properties
     */
    fun <T> getAllProperties(): Map<String, IProperty<T>> =
            propertyList.mapValues { it.value as IProperty<T> }

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
     * Stores a given property, using a common property
     */
    fun putProperty(commonProperty: CommonProperties, property: IProperty<*>): IProperty<*> =
            this.putProperty(commonProperty.key, property)

    /**
     * Stores a compound containing other properties
     */
    fun <T> putCompoundProperty(key: String, property: IProperty<T>): CompoundProperty<T> =
            putProperty(key, property) as CompoundProperty<T>

    /**
     * Removes all properties
     */
    fun clearProperties() {
        this.propertyList.clear()
    }
}