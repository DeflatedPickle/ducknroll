package com.deflatedpickle.ducknroll.common.api.registry

import kotlin.reflect.KFunction

interface IRegistry<K, V : KFunction<IHasRegistry>> {
    fun register(key: K, value: V)
    fun has(key: K): Boolean
    fun get(key: K): V?
    fun getAll(): Map<K, V>
}