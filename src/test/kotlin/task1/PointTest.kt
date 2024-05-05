package task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.kpfu.khismatova.task1.Point

class PointTest {

    @ParameterizedTest
    @CsvSource(
        "3.0, 4.0, 3.0, 4.0, 0.0",
        "1.0, 1.0, 1.0, 1.0, 0.0",
        "1.0, 2.0, 4.0, 6.0, 5.0",
        "-1.0, -1.0, -4.0, -5.0, 5.0"
    )
    fun testDistance(x1: Double, y1: Double, x2: Double, y2: Double, expectedDistance: Double) {
        val pointA = Point(x1, y1)
        val pointB = Point(x2, y2)
        val distance = pointA.distance(pointB)
        assertEquals(expectedDistance, distance)
    }
}
