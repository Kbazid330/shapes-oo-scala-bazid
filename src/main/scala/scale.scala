package edu.luc.cs.laufer.cs371.shapes

import Shape.*

/** Recursively scales every dimension of a shape, including locations,
  * by the given positive factor. Curried so that `scale(2)` is itself
  * a Shape => Shape function.
  */
object scale:

  def apply(factor: Int)(s: Shape): Shape =
    require(factor > 0, s"scaling factor must be positive: $factor")
    val result = s match
      case Rectangle(w, h)       => Rectangle(w * factor, h * factor)
      case Ellipse(rx, ry)       => Ellipse(rx * factor, ry * factor)
      case Location(x, y, shape) => Location(x * factor, y * factor, apply(factor)(shape))
      case Group(shapes*)        => Group(shapes.map(apply(factor))*)
    Log.debug(s"scale($factor)($s) = $result")
    result

end scale
