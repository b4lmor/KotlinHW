import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt


/**
* Точка на плоскости
  */
  data class Point(val x: Double, val y: Double) {
  /**
    * Найти расстояние между двумя точками как квадратный корень из суммы квадратов разностей координат x, y
      */
      fun distance(other: Point): Double = TODO()
      }


/**
* Отрезок между двумя точками
  */
  data class Segment(val begin: Point, val end: Point) {
  override fun equals(other: Any?): Boolean =
  other is Segment && (begin == other.begin && end == other.end || end == other.begin && begin == other.end)
  override fun hashCode() = begin.hashCode() + end.hashCode()
  }


/**
* Треугольник, заданный тремя точками.
  */
  class Triangle private constructor(private val points: Set<Point>) {
  private val pointList = points.toList()
  val a: Point get() = pointList[0]
  val b: Point get() = pointList[1]
  val c: Point get() = pointList[2]

  /**
    * Написать конструктор класса из трех точек
      */
      constructor(a: Point, b: Point, c: Point) : TODO()

  /**
    * Найти периметр треугольника
      */
      fun perimeter(): Double = TODO()

  /**
    * Найти площадь треугольника
      */
      fun area(): Double = TODO()

  /**
    * Вернуть true если точка находится внутри треугольника
    * Для вычисления необходимо построить треугольники ABP, BCP, ACP и сравнить сумму их площадей с площадью ABC
      */
      fun contains(p: Point): Boolean = TODO()

  override fun equals(other: Any?) = other is Triangle && points == other.points
  override fun hashCode() = points.hashCode()
  override fun toString() = "Triangle(a = $a, b = $b, c = $c)"
  }


/**
* Окружность с заданным центром и радиусом
  */
  data class Circle(val center: Point, val radius: Double) {
  /**
    * Написать конструктор окружности, построенной на сегменте
      */
      constructor(diameter: Segment) : TODO()

  /**
    * Написать конструктор строящий окружность, описанную вокруг треугольника
      */
      constructor(triangle: Triangle) = TODO()

  /**
    * Рассчитать расстояние между двумя окружностями.
    * Расстояние между непересекающимися окружностями рассчитывается как
    * расстояние между их центрами минус сумма их радиусов.
    * Расстояние между пересекающимися окружностями считать равным 0.0.
      */
      fun distance(other: Circle): Double = TODO()

  /**
    * Вернуть true, если и только если окружность содержит данную точку НА себе или ВНУТРИ себя
      */
      fun contains(p: Point): Boolean = TODO()
      }

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
      constructor(a: Point, b: Point): TODO()

  /**
    * Написать конструктор строящий прямую по отрезку
      */
      constructor(s: Segment): TODO()

  /**
    * Написать конструктор строящий серединный перпендикуляр к отрезку
      */
      constructor(s: Segment): TODO()

    /**
     * Найти точку пересечения с другой линией.
     * Для этого необходимо составить и решить систему из двух уравнений (каждое для своей прямой)
     */
    fun crossPoint(other: Line): Point = TODO()

    override fun equals(other: Any?) = other is Line && angle == other.angle && b == other.b
    override fun hashCode(): Int {
        var result = b.hashCode()
        result = 31 * result + angle.hashCode()
        return result
    }
    override fun toString() = "Line(${cos(angle)} * y = ${sin(angle)} * x + $b)"
}

