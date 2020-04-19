package com.deflatedpickle.ducknroll.common.api.entity

interface IUpdate {
    fun preUpdate() {}
    fun update()
    fun postUpdate() {}
}