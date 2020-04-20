package com.deflatedpickle.ducknroll.common.api.clock

interface IClock<O> {
    /**
     * Begins the clock
     */
    fun start()

    /**
     * Furthers the clock
     */
    fun tick()
}