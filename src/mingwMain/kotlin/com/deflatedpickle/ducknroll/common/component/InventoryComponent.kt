package com.deflatedpickle.ducknroll.common.component

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.component.IComponent
import com.deflatedpickle.ducknroll.common.api.property.ListProperty
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties

class InventoryComponent : PropertyHolder(), IComponent {
    init {
        this.putProperty(
            CommonProperties.INVENTORY,
            ListProperty<Object>()
        )
    }

    override fun update() {
    }

    override fun catchup() {
    }
}