package com.deflatedpickle.ducknroll.common.api.property

import com.deflatedpickle.ducknroll.common.api.matrix.ListMatrix
import com.deflatedpickle.ducknroll.common.api.matrix.Matrix
import com.deflatedpickle.ducknroll.common.api.matrix.MutableListMatrix

class MatrixProperty<T>(value: ListMatrix<T>) : AbstractProperty<Matrix<T>>(value)