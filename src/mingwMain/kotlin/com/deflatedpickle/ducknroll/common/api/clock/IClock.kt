package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.various.IUpdate

interface IClock<O> : IUpdate {
    /**
     * Begins the clock
     */
    fun start()
}