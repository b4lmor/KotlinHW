package task2

inline fun <reified E> transpose(matrix: Matrix<E>): Matrix<E> {
    val height = matrix.width
    val width = matrix.height
    val transposedMatrix = Array(width) { row -> Array(height) { column -> matrix[column, row] } }
    return MatrixImpl(width, height, transposedMatrix)
}

operator fun Matrix<Int>.plus(other: Matrix<Int>): Matrix<Int> {
    require(this.height == other.height && this.width == other.width) {
       "Matrix dimensions don't match for addition."
    }

    val resultMatrix = Array(height) { row ->
        Array(width) { column -> this[row, column] + other[row, column] }
    }

    return MatrixImpl(height, width, resultMatrix)
}

operator fun Matrix<Int>.times(other: Matrix<Int>): Matrix<Int> {
    require(this.width == other.height) { "Matrix dimensions are not compatible for multiplication." }

    val resultMatrix = Array(this.height) { i ->
        Array(other.width) { j ->
            var sum = 0
            for (k in 0 until this.width) {
                sum += this[i, k] * other[k, j]
            }
            sum
        }
    }

    return MatrixImpl(this.height, other.width, resultMatrix)
}
