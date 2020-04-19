package com.deflatedpickle.ducknroll.common.api.clock

interface IClock<T, O> {
    /**
     * Begins the clock
     */
    fun start()

    /**
     * Furthers the clock
     */
    fun tick()

    /**
     * Runs the clock
     */
    fun run()

    /**
     * Tells the clock to manage this object
     */
    fun addObject(obj: O)
}