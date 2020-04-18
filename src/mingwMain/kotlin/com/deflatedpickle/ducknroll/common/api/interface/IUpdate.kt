package com.deflatedpickle.ducknroll.common.api.`interface`

interface IUpdate {
    fun preUpdate(deltaTime: Float) {}
    fun update(deltaTime: Float)
    fun postUpdate(deltaTime: Float) {}
}