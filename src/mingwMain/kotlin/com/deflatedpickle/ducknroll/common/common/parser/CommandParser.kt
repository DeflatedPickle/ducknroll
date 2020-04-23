package com.deflatedpickle.ducknroll.common.common.parser

import com.deflatedpickle.ducknroll.common.api.command.ICommand
import com.deflatedpickle.ducknroll.common.api.parser.IParse
import com.deflatedpickle.ducknroll.common.common.command.HelpCommand
import com.deflatedpickle.ducknroll.common.common.registry.Registries

object CommandParser : IParse<String, ICommand> {
    // TODO: Create a CommandStack and push commands to it
    override fun parse(input: String): ICommand? {
        val split = input.split(' ')

        // Check if it's valid
        val command = Registries.command
        if (command.has(split[0])) {
            // Wow, command! You're so valid uwu
            command.get(split[0])?.run {
                // I need to get that constructed instance to change the arguments
                println(this.returnType.classifier)
            }
        }
        else {
            println("Sorry, I don't know that command")
        }

        return null
    }
}