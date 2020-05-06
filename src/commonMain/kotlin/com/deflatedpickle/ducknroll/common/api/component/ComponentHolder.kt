package com.deflatedpickle.ducknroll.common.api.component

import kotlin.reflect.KClass

interface ComponentHolder {
    fun <T : IComponent> addComponent(component: T): T

    fun <T : IComponent> getComponent(index: Int): T
    fun <T : IComponent> getComponent(type: KClass<T>): T?

    fun getAllComponents(): List<IComponent>
    fun getAllComponents(type: KClass<IComponent>): List<IComponent>
}