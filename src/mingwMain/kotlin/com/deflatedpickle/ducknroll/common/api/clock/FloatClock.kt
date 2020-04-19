package com.deflatedpickle.ducknroll.common.api.clock

import com.deflatedpickle.ducknroll.common.api.entity.IUpdate

open class FloatClock<O : IUpdate> : AbstractClock<Float, O>()