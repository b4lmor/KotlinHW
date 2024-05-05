package ru.kpfu.khismatova.task1

import kotlin.math.sqrt

/**
 * Треугольник, заданный тремя точками.
 */
class Triangle private constructor(private val points: Set<Point>) {

    private val pointList = points.toList()

    val a: Point get() = pointList[0]

    val b: Point get() = pointList[1]

    val c: Point get() = pointList[2]

    constructor(a: Point, b: Point, c: Point) : this(setOf(a, b, c))

    init {
        require(pointList.size == 3) { "points must contain exactly 3 different points" }
    }

    /**
     * Найти периметр треугольника
     */
    fun perimeter(): Double = a.distance(b) + b.distance(c) + c.distance(a)

    /**
     * Найти площадь треугольника (формула Герона)
     */
    fun area(): Double {
        val p = perimeter() / 2
        return sqrt(p * (p - a.distance(b)) * (p - b.distance(c)) * (p - c.distance(a)))
    }

    /**
     * Вернуть true если точка находится внутри треугольника
     * Для вычисления необходимо построить треугольники ABP, BCP, ACP и сравнить сумму их площадей с площадью ABC
     */
    fun contains(p: Point): Boolean =
        Triangle(a, b, p).area() + Triangle(b, c, p).area() + Triangle(c, a, p).area() == area()

    override fun equals(other: Any?) = other is Triangle && points == other.points

    override fun hashCode() = points.hashCode()

    override fun toString() = "Triangle(a = $a, b = $b, c = $c)"

}
