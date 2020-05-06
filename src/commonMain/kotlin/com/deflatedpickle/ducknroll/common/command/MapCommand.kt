package com.deflatedpickle.ducknroll.common.command

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.command.AbstractCommand

class MapCommand : AbstractCommand("map", 1, 1) {
    private val validArguments = listOf("world", "dimension", "area")

    override fun isArgumentValid(argument: Any): Boolean = argument in validArguments

    override fun run(executor: Object): Boolean {
        this.argumentCheck()

        if (this.arguments.size > 0) {
            when (this.arguments[0]) {
                "world" -> {
                }
                "dimension" -> {
                }
                "area" -> {
                    executor.getAllProperties()
                }
            }
        }

        return false
    }
}