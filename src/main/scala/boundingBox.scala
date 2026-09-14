package edu.luc.cs.laufer.cs371.shapes

import Shape.*

/** Computes the smallest axis-aligned box containing a shape,
  * expressed as a Location wrapping a Rectangle.
  */
object boundingBox:

  /** Bounds of a shape as (left, top, right, bottom). */
  private type Bounds = (Int, Int, Int, Int)

  /** Smallest box containing both arguments. */
  private def union(a: Bounds, b: Bounds): Bounds =
    (a._1 min b._1, a._2 min b._2, a._3 max b._3, a._4 max b._4)

  private def bounds(s: Shape): Bounds =
    val result: Bounds = s match
      case Rectangle(w, h) => (0, 0, w, h)
      case Ellipse(rx, ry) => (-rx, -ry, rx, ry)
      case Location(x, y, shape) =>
        val (l, t, r, b) = bounds(shape)
        (l + x, t + y, r + x, b + y)
      case Group(shapes*) =>
        shapes.map(bounds) match
          case head +: tail => tail.foldLeft(head)(union)
          case _            => (0, 0, 0, 0) // unreachable: groups are nonempty
    Log.debug(s"bounds($s) = $result")
    result

  def apply(s: Shape): Location =
    val (left, top, right, bottom) = bounds(s)
    val result: Location = Location(left, top, Rectangle(right - left, bottom - top))
    Log.debug(s"boundingBox($s) = $result")
    result

end boundingBox
