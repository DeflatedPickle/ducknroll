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
        if (Registries.command.has(split[0])) {
            // Wow, command! You're so valid uwu
            with(HelpCommand()) {
                Registries.command.get(split[0])?.invoke(this, split.drop(1))
                return this
            }
        }
        else {
            println("Sorry, I don't know that command")
        }

        return null
    }
}