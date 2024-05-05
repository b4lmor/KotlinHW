package task2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MatrixImplTest {

    @Test
    fun createMatrixZero() {
        val matrix = MatrixImpl.createMatrix(2, 3, 0)
        assertEquals(2, matrix.height)
        assertEquals(3, matrix.width)
        for (row in 0 until 2) {
            for (col in 0 until 3) {
                assertEquals(0, matrix[row, col])
            }
        }
    }

    @Test
    fun setElementSuccessfully() {
        val matrix = MatrixImpl.createMatrix(2, 2, "A")
        assertEquals("A", matrix[0, 1])
        matrix[0, 1] = "B"
        assertEquals("B", matrix[0, 1])
    }

    @Test
    fun equalsCompareMatricesWithSameContent() {
        val matrix1 = MatrixImpl.createMatrix(2, 2, "X")
        val matrix2 = MatrixImpl.createMatrix(2, 2, "X")
        assertTrue(matrix1 == matrix2)
    }

    @Test
    fun equalsCompareMatricesWithDifferentContent() {
        val matrix1 = MatrixImpl.createMatrix(2, 2, "X")
        val matrix2 = MatrixImpl.createMatrix(2, 2, "Y")
        assertFalse(matrix1 == matrix2)
    }

    @Test
    fun toStringMatrixStringRepresentationCorrectFormat() {
        val matrix = MatrixImpl.createMatrix(2, 2, 1)
        val expectedString = "1 1 \n1 1 \n"
        assertEquals(expectedString, matrix.toString())
    }
}
