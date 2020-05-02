package com.deflatedpickle.ducknroll.common.registry

import com.deflatedpickle.ducknroll.common.api.command.ICommand

// JVM: One type argument expected for class ThreadLocal<T : Any!>
// JS: Unresolved reference: ThreadLocal
@ThreadLocal
object Registries {
    val command = Registry<String, () -> ICommand>()
}