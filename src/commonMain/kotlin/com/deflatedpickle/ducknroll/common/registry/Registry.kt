package com.deflatedpickle.ducknroll.common.registry

import com.deflatedpickle.ducknroll.common.api.registry.IHasRegistry
import com.deflatedpickle.ducknroll.common.api.registry.IRegistry

/**
 * @sample Registries.command
 */
class Registry<K, V : () -> IHasRegistry> : IRegistry<K, V> {
    private val items = mutableMapOf<K, V>()

    override fun register(key: K, value: V) {
        this.items[key] = value
    }

    override fun has(key: K): Boolean = this.items.containsKey(key)

    override fun get(key: K): V? = this.items[key]

    override fun getAll(): Map<K, V> = this.items
}