package ru.kpfu.khismatova

/**
 * Окружность с заданным центром и радиусом
 */
data class Circle(val center: Point, val radius: Double) {

    /**
     * Написать конструктор окружности, построенной на сегменте
     */
    constructor(diameter: Segment) : this(diameter.findCenter(), diameter.begin.distance(diameter.end) / 2)

    /**
     * Написать конструктор строящий окружность, описанную вокруг треугольника
     */
    constructor(triangle: Triangle) : this(findCenter(triangle), findRadius(triangle))

    companion object {
        /**
         * Алгоритм поиска координат цетра окружности по трём точкам:
         * 1. Найдите координаты середины отрезка, соединяющего первую и вторую точки. Обозначим эти координаты как (x1, y1).
         * 2. Найдите координаты середины отрезка, соединяющего вторую и третью точки. Обозначим эти координаты как (x2, y2).
         * 3. Найдите угловой коэффициент прямой, проходящей через первую и вторую точки, используя формулу: m1 = (y2 — y1) / (x2 — x1).
         * 4. Найдите угловой коэффициент прямой, проходящей через вторую и третью точки, используя формулу: m2 = (y3 — y2) / (x3 — x2).
         * 5. Найдите координаты центра окружности, используя формулы: x = (m1 * m2 * (y1 — y3) + m2 * (x1 + x2) — m1 * (x2 + x3)) / (2 * (m2 — m1)). y = -1 * (x — (x1 + x2) / 2) / m1 + (y1 + y2) / 2.
         */
        private fun findCenter(triangle: Triangle): Point {
            val s1 = Segment(triangle.a, triangle.b).findCenter()
            val s2 = Segment(triangle.b, triangle.c).findCenter()
            val s3 = Segment(triangle.c, triangle.a).findCenter()
            val y1 = s1.y
            val x1 = s1.x
            val y2 = s2.y
            val x2 = s2.x
            val y3 = s3.y
            val x3 = s3.x
            val m1 = (y2 - y1) / (x2 - x1)
            val m2 = (y3 - y2) / (x3 - x2)
            val x = (m1 * m2 * (y1 - y3) + m2 * (x1 + x2) - m1 * (x2 + x3)) / (2 * (m2 - m1))
            val y = -1 * (x - (x1 + x2) / 2) / m1 + (y1 + y2) / 2
            return Point(x, y)
        }

        /**
         * R = abc / 4S
         * */
        private fun findRadius(triangle: Triangle): Double =
            (triangle.a.distance(triangle.b) * triangle.b.distance(triangle.c) * triangle.c.distance(triangle.a)) /
                    (4 * triangle.area())
    }

    /**
     * Рассчитать расстояние между двумя окружностями.
     * Расстояние между непересекающимися окружностями рассчитывается как
     * расстояние между их центрами минус сумма их радиусов.
     * Расстояние между пересекающимися окружностями считать равным 0.0.
     */
    fun distance(other: Circle): Double {
        val dist = center.distance(other.center)
        return if (dist > radius + other.radius) {
            dist - radius - other.radius
        } else {
            0.0
        }
    }

    /**
     * Вернуть true, если и только если окружность содержит данную точку НА себе или ВНУТРИ себя
     */
    fun contains(p: Point): Boolean = center.distance(p) <= radius

}