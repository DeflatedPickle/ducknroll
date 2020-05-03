package com.deflatedpickle.ducknroll.common.command

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.command.AbstractCommand

class HelpCommand : AbstractCommand("help", 1, 1) {
    // I'm not sure how I want this to work yet
    override fun isArgumentValid(argument: Any): Boolean = false

    override fun run(executor: Object): Boolean {
        this.argumentCheck()
        return false
    }
}