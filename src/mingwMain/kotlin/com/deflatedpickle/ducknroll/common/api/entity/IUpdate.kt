package com.deflatedpickle.ducknroll.common.api.entity

import com.deflatedpickle.ducknroll.common.api.`object`.IObject

interface IUpdate : IObject {
    fun preUpdate() {}
    fun update()
    fun postUpdate() {}
}