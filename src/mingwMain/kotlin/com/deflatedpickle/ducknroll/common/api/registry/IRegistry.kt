package com.deflatedpickle.ducknroll.common.api.registry

import kotlin.reflect.KFunction2

interface IRegistry<K, V : KFunction2<IHasRegistry, List<Any>, Unit>> {
    fun register(key: K, value: V)
    fun has(key: K): Boolean
    fun get(key: K): V?
    fun getAll(): Map<K, V>
}