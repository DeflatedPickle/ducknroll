package com.deflatedpickle.ducknroll.common.api.parser

interface IParse<I, O> {
    fun parse(input: I): O?
}