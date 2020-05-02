package com.deflatedpickle.ducknroll.common.api.command

import com.deflatedpickle.ducknroll.common.api.registry.IHasRegistry

// TODO: Commands need an enum for categories
interface ICommand : IHasRegistry {
    fun getName(): String

    fun isArgumentValid(argument: Any): Boolean

    fun run(): Boolean
    fun fail(): String
}