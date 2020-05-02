package com.deflatedpickle.ducknroll.common.parser

import com.deflatedpickle.ducknroll.common.api.command.AbstractCommand
import com.deflatedpickle.ducknroll.common.api.command.ICommand
import com.deflatedpickle.ducknroll.common.api.parser.IParse
import com.deflatedpickle.ducknroll.common.registry.Registries

object CommandParser :
    IParse<String, ICommand> {
    // TODO: Create a CommandStack and push commands to it
    override fun parse(input: String): ICommand? {
        val split = input.split(' ')

        // Check if it's valid
        val command = Registries.command
        if (command.has(split[0])) {
            // Wow, command! You're so valid uwu
            command.get(split[0])?.invoke()?.let {
                (it as AbstractCommand).arguments.addAll(split.drop(1))
                return it
            }
        }
        else {
            println("Sorry, I don't know that command")
        }

        return null
    }
}