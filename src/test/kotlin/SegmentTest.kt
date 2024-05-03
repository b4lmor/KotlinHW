import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.kpfu.khismatova.Point
import ru.kpfu.khismatova.Segment

class SegmentTest {

    @ParameterizedTest
    @CsvSource(
        "1.0, 1.0, 5.0, 5.0, 3.0, 3.0",
        "-2.0, -2.0, 2.0, 2.0, 0.0, 0.0"
    )
    fun testFindCenter(
        beginX: Double, beginY: Double,
        endX: Double, endY: Double,
        centerX: Double, centerY: Double
    ) {
        val begin = Point(beginX, beginY)
        val end = Point(endX, endY)
        val segment = Segment(begin, end)

        val center = segment.findCenter()
        val expectedCenter = Point(centerX, centerY)

        assertEquals(expectedCenter, center)
    }
}
