import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.kpfu.khismatova.Point
import ru.kpfu.khismatova.Triangle

class TriangleTest {

    @ParameterizedTest
    @CsvSource(
        "0.0, 0.0, 3.0, 0.0, 0.0, 4.0, 6.0, 6.0",
        "0.0, 0.0, 4.0, 0.0, 0.0, 3.0, 6.0, 6.0"
    )
    fun testArea(
        aX: Double, aY: Double,
        bX: Double, bY: Double,
        cX: Double, cY: Double,
        expectedArea: Double
    ) {
        val a = Point(aX, aY)
        val b = Point(bX, bY)
        val c = Point(cX, cY)
        val triangle = Triangle(a, b, c)

        assertEquals(expectedArea, triangle.area())
    }

    @ParameterizedTest
    @CsvSource(
        "0.0, 0.0, 3.0, 0.0, 0.0, 4.0, 12.0",
        "0.0, 0.0, 4.0, 4.0, 4.0, 0.0, 12.0"
    )
    fun testPerimeter(
        aX: Double, aY: Double,
        bX: Double, bY: Double,
        cX: Double, cY: Double,
        expectedPerimeter: Double
    ) {
        val a = Point(aX, aY)
        val b = Point(bX, bY)
        val c = Point(cX, cY)
        val triangle = Triangle(a, b, c)

        assertEquals(expectedPerimeter, triangle.perimeter())
    }

    @ParameterizedTest
    @CsvSource(
        "2.0, 2.0, 4.0, 2.0, 3.0, 3.0, 3.0, 2.0, true",
        "-2.0, 0.0, 6.0, 0.0, 0.0, 6.0, 3.0, 3.0, false"
    )
    fun testContains(
        aX: Double, aY: Double,
        bX: Double, bY: Double,
        cX: Double, cY: Double,
        pX: Double, pY: Double,
        expectedResult: Boolean
    ) {
        val a = Point(aX, aY)
        val b = Point(bX, bY)
        val c = Point(cX, cY)
        val triangle = Triangle(a, b, c)
        val point = Point(pX, pY)

        assertEquals(expectedResult, triangle.contains(point))
    }
}