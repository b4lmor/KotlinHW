package task2

/**
 * Реализация интерфейса "матрица"
 */
class MatrixImpl<E>(override val height: Int, override val width: Int, private val matrix: Array<Array<E>>) :
    Matrix<E> {

    init {
        require(height > 0 || width > 0) { "height and width must be positive!" }
    }

    companion object {
        /**
         * Метод для создания матрицы, должен вернуть РЕАЛИЗАЦИЮ Matrix<E>.
         * height - высота, width - ширина, e = значение типа E для заполнения элементов.
         * Бросить исключение IllegalArgumentException, если height или width <= 0. (сделано в блоке init)
         */
        inline fun <reified E> createMatrix(height: Int, width: Int, e: E): Matrix<E> {
            val matrix = Array(height) { Array(width) { e } }
            return MatrixImpl(height, width, matrix)
        }
    }

    override fun get(row: Int, column: Int): E = matrix[row][column]

    override fun get(cell: Cell): E = matrix[cell.row][cell.column]

    override fun set(row: Int, column: Int, value: E) {
        matrix[row][column] = value
    }

    override fun set(cell: Cell, value: E) {
        matrix[cell.row][cell.column] = value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Matrix<*>) {
            return false
        }

        other as MatrixImpl<*>

        if (height != other.height || width != other.width) {
            return false
        }
        if (!matrix.contentDeepEquals(other.matrix)) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + width
        result = 31 * result + matrix.contentDeepHashCode()
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (row in matrix) {
            for (element in row) {
                sb.append("$element ")
            }
            sb.append("\n")
        }
        return sb.toString()
    }

}
