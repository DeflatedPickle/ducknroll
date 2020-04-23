package com.deflatedpickle.ducknroll.common.api.registry

import kotlin.reflect.KFunction
import kotlin.reflect.KFunction2

interface IHasRegistry {
    fun <T : IHasRegistry> getRegistry(): IRegistry<String, KFunction<IHasRegistry>>
}