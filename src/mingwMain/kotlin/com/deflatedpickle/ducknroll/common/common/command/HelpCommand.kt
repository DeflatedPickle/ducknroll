package com.deflatedpickle.ducknroll.common.common.command

import com.deflatedpickle.ducknroll.common.api.command.AbstractCommand

class HelpCommand : AbstractCommand("help", 1, 1) {
    override fun run(): Boolean {
        this.argumentCheck()
        return false
    }
}