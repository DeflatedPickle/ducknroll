package com.deflatedpickle.ducknroll.common.api.registry

import com.deflatedpickle.ducknroll.common.registry.Registry

/**
 * @sample Registry
 */
interface IRegistry<K, V : () -> IHasRegistry> {
    fun register(key: K, value: V)
    fun has(key: K): Boolean
    fun get(key: K): V?
    fun getAll(): Map<K, V>
}