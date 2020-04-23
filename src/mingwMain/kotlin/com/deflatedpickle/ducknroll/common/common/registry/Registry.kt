package com.deflatedpickle.ducknroll.common.common.registry

import com.deflatedpickle.ducknroll.common.api.registry.IHasRegistry
import com.deflatedpickle.ducknroll.common.api.registry.IRegistry
import kotlin.reflect.KFunction2

class Registry<K, V : KFunction2<IHasRegistry, List<Any>, Unit>> : IRegistry<K, V> {
    private val items = mutableMapOf<K, V>()

    override fun register(key: K, value: V) {
        this.items[key] = value
    }

    override fun has(key: K): Boolean = this.items.containsKey(key)

    override fun get(key: K): V? = this.items[key]

    override fun getAll(): Map<K, V> = this.items
}