package com.deflatedpickle.ducknroll.common.common.registry

import com.deflatedpickle.ducknroll.common.api.registry.IHasRegistry
import kotlin.reflect.KFunction

@ThreadLocal
object Registries {
    val command = Registry<String, KFunction<IHasRegistry>>()
}