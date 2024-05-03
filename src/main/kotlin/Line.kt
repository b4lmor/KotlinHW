package ru.kpfu.khismatova

import kotlin.math.*

/**
 * Прямая, заданная точкой point и углом наклона angle (в радианах) по отношению к оси X.
 * Уравнение прямой: (y - point.y) * cos(angle) = (x - point.x) * sin(angle)
 * или: y * cos(angle) = x * sin(angle) + b, где b = point.y * cos(angle) - point.x * sin(angle).
 * Угол наклона обязан находиться в диапазоне от 0 (включительно) до PI (исключительно).
 */
class Line private constructor(val b: Double, val angle: Double) {

    init {
        require(angle >= 0 && angle < PI) { "Incorrect line angle: $angle" }
    }

    constructor(point: Point, angle: Double) : this(point.y * cos(angle) - point.x * sin(angle), angle)

    /**
     * Написать конструктор строящий прямую по двум точкам
     */
    constructor(a: Point, b: Point): this(findShift(a, b), atan(findTan(a, b)))

    /**
     * Написать конструктор строящий прямую по отрезку
     */
    constructor(s: Segment): this(s.begin, s.end)

    companion object {

        fun findTan(a: Point, b: Point) : Double = (b.y - a.y) / (b.x - a.x) // tan = dy / dx

        fun findShift(a: Point, b: Point): Double = a.y - findTan(a, b) * a.x // y1 = kx1 + b

        /**
         * Написать конструктор строящий серединный перпендикуляр к отрезку
         * comment: Написать конструктор с повторной сигнатурой нельзя, т.к. это вызовет ошибку (ambiguous call)
         */
        fun findPerpendicular(s: Segment): Line {
            val angle = (atan(findTan(s.begin, s.end)) + PI / 2) % PI
            val k = tan(angle)
            val shift = s.begin.y - k * s.begin.x // ?
            return Line(shift, angle)
        }
    }

    /**
     * Найти точку пересечения с другой линией.
     * Для этого необходимо составить и решить систему из двух уравнений (каждое для своей прямой)
     */
    fun crossPoint(other: Line): Point? {
        val b1 = b
        val b2 = other.b
        val k1 = tan(angle)
        val k2 = tan(other.angle)
        if (k1 == k2) {
            return null
        }
        val x = (b1 - b2) / (k2 - k1)
        val y = b1 + k1 * x
        return Point(x, y)
    }

    override fun equals(other: Any?) = other is Line && angle == other.angle && b == other.b

    override fun hashCode(): Int {
        var result = b.hashCode()
        result = 31 * result + angle.hashCode()
        return result
    }

    override fun toString() = "Line(${cos(angle)} * y = ${sin(angle)} * x + $b)"

}
