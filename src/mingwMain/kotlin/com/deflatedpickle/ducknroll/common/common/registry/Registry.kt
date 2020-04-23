package com.deflatedpickle.ducknroll.common.common.registry

import com.deflatedpickle.ducknroll.common.api.registry.IHasRegistry
import com.deflatedpickle.ducknroll.common.api.registry.IRegistry
import com.deflatedpickle.ducknroll.common.common.command.HelpCommand
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction2

class Registry<K, V : KFunction<IHasRegistry>> : IRegistry<K, V> {
    private val items = mutableMapOf<K, V>()

    override fun register(key: K, value: V) {
        this.items[key] = value
    }

    override fun has(key: K): Boolean = this.items.containsKey(key)

    override fun get(key: K): V? = this.items[key]

    override fun getAll(): Map<K, V> = this.items
}