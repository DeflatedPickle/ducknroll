package com.deflatedpickle.ducknroll.common.api.registry

interface IHasRegistry {
    fun <T : IHasRegistry> getRegistry(): IRegistry<String, () -> T>
}