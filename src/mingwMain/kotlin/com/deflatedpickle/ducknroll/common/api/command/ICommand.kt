package com.deflatedpickle.ducknroll.common.api.command

import com.deflatedpickle.ducknroll.common.api.registry.IHasRegistry
import com.deflatedpickle.ducknroll.common.api.various.ICreated

// TODO: Commands need an enum for categories
interface ICommand : IHasRegistry /*, ICreated<ICommand>*/ {
    fun getName(): String

    fun run(): Boolean
    fun fail(): String
}