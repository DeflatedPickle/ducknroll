package com.deflatedpickle.ducknroll.common.api.area

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

// TODO: Add a time offset for areas
class Area : PropertyHolder() {
    init {
        this.putProperty(CommonProperties.OBJECT, ListProperty<Object>())
    }

    fun spawn(entity: Object) {
        this.getProperty<MutableList<Object>>(CommonProperties.OBJECT).getValue().add(entity)
    }
}