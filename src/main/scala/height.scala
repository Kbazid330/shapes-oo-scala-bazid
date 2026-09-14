package edu.luc.cs.laufer.cs371.shapes

import Shape.*

/** Height of the shape tree, counting every kind of node.
  * A leaf shape has height 1; Location and Group each add one level.
  */
object height:

  def apply(s: Shape): Int =
    val result = s match
      case Rectangle(_, _)    => 1
      case Ellipse(_, _)      => 1
      case Location(_, _, sh) => 1 + apply(sh)
      case Group(shapes*)     => 1 + shapes.map(apply).max
    Log.debug(s"height($s) = $result")
    result

end height
