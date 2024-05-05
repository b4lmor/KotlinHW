package ru.kpfu.khismatova.task1

import kotlin.math.sqrt

/**
 * Точка на плоскости
 */
data class Point(val x: Double, val y: Double) {

    /**
     * Найти расстояние между двумя точками как квадратный корень из суммы квадратов разностей координат x, y
     */
    fun distance(other: Point): Double = sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y))

}
