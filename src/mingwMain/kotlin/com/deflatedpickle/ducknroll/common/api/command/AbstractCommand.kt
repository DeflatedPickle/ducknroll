package com.deflatedpickle.ducknroll.common.api.command

import com.deflatedpickle.ducknroll.common.api.registry.IHasRegistry
import com.deflatedpickle.ducknroll.common.api.registry.IRegistry
import com.deflatedpickle.ducknroll.common.common.registry.Registries
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction2

abstract class AbstractCommand(
    private val name: String,
    private val argumentMinimum: Int = 0,
    private val argumentMaximum: Int = 1
) : ICommand {
    val arguments = mutableListOf<Any>()

    override fun getName(): String = this.name

    override fun fail(): String = "That isn't a valid command and/or argument"

    override fun <T : IHasRegistry> getRegistry(): IRegistry<String, () -> T> =
        Registries.command as IRegistry<String, () -> T>

    fun argumentCheck() {
        when {
            this.arguments.size < this.argumentMinimum -> {
                println("Sorry, you have provided too few arguments")
            }
            this.arguments.size > this.argumentMaximum -> {
                println("Sorry, you have provided too many arguments")
            }
            else -> {
                val validArguments = this.arguments.filter {
                    this.isArgumentValid(it)
                }

                with (this.arguments.filterNot { it in validArguments }) {
                    if (this.isNotEmpty()) {
                        println("Sorry, I don't know the arguments: $this")
                    }
                }

                arguments.removeAll { it !in validArguments }
            }
        }
    }
}