package ru.kpfu.khismatova.task1

/**
 * Отрезок между двумя точками
 */
data class Segment(val begin: Point, val end: Point) {

    override fun equals(other: Any?): Boolean =
        other is Segment && (begin == other.begin && end == other.end || end == other.begin && begin == other.end)

    override fun hashCode(): Int = begin.hashCode() + end.hashCode()

    fun findCenter(): Point = Point((begin.x + end.x) / 2, (begin.y + end.y) / 2)

}
