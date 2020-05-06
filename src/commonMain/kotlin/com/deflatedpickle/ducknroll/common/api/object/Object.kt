package com.deflatedpickle.ducknroll.common.api.`object`

import com.deflatedpickle.ducknroll.common.api.component.ComponentHolder
import com.deflatedpickle.ducknroll.common.api.component.IComponent
import com.deflatedpickle.ducknroll.common.api.property.PropertyHolder
import com.deflatedpickle.ducknroll.common.api.property.StringProperty
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.api.various.ICatchup
import com.deflatedpickle.ducknroll.common.api.various.IName
import com.deflatedpickle.ducknroll.common.api.various.IUpdate
import kotlin.reflect.KClass

abstract class Object : PropertyHolder(),
    ComponentHolder,
    IUpdate,
    ICatchup {
    private val componentList = mutableListOf<IComponent>()

    override fun update() {
        for (component in this.componentList) {
            component.update()
        }
    }

    override fun catchup() {
        for (component in this.componentList) {
            component.catchup()
        }
    }

    override fun <T : IComponent> addComponent(component: T): T =
        component.also { this.componentList.add(it) }

    @Suppress("UNCHECKED_CAST")
    override fun <T : IComponent> getComponent(index: Int): T =
        this.componentList[index] as T

    @Suppress("UNCHECKED_CAST")
    override fun <T : IComponent> getComponent(type: KClass<T>): T? =
        this.componentList.single { it::class == type } as T?

    override fun getAllComponents(): List<IComponent> = this.componentList

    override fun getAllComponents(type: KClass<IComponent>): List<IComponent> =
        this.componentList.filter { it::class == type  }

    override fun toString(): String = "${this::class.simpleName} { properties=${this.getAllProperties()}, components=${this.getAllComponents()} }"
}