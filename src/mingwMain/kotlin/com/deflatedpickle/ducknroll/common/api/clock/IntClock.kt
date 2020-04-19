package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.entity.IUpdate

open class IntClock<T : IUpdate> : AbstractClock<Int, T>()