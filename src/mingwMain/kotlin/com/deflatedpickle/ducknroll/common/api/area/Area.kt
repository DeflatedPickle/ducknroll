package com.deflatedpickle.ducknroll.common.api.area

import com.deflatedpickle.ducknroll.common.api.`object`.IObject
import com.deflatedpickle.ducknroll.common.api.entity.IUpdate
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

// TODO: Add a time offset for areas
class Area : PropertyHolder() {
    init {
        this.putProperty(CommonProperties.OBJECT, ListProperty<IObject>())
    }

    fun spawn(entity: IUpdate) {
        this.getProperty<MutableList<IObject>>(CommonProperties.OBJECT).getValue().add(entity)
    }
}