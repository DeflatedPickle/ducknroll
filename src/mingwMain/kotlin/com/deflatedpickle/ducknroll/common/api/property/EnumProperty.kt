package com.deflatedpickle.ducknroll.common.api.property

class EnumProperty<T : Enum<T>>(value: Enum<T>) : AbstractProperty<Enum<T>>(value)