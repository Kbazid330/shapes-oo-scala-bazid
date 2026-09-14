package edu.luc.cs.laufer.cs371.shapes

import Shape.*

/** Counts the concrete leaf shapes (rectangles and ellipses) in a shape. */
object size:

  def apply(s: Shape): Int =
    val result = s match
      case Rectangle(_, _)    => 1
      case Ellipse(_, _)      => 1
      case Location(_, _, sh) => apply(sh)
      case Group(shapes*)     => shapes.map(apply).sum
    Log.debug(s"size($s) = $result")
    result

end size
