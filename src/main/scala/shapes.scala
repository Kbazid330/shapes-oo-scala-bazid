package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h)
  *           | Ellipse(rx, ry)
  *           | Location(x, y, Shape)
  *           | Group(Shape*)
  *
  * A Rectangle sits with its upper-left corner at the origin and extends to
  * (width, height). An Ellipse is centered at the origin, so `radiusX` and
  * `radiusY` are its semi-axes and it extends from (-radiusX, -radiusY) to
  * (radiusX, radiusY). Location translates its child shape by (x, y), and
  * Group overlays one or more shapes in the same coordinate system.
  */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Ellipse(radiusX: Int, radiusY: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Group(shapes: Shape*)

  /** Constructor validity checking. This runs for every Shape instance:
    * dimensions must be strictly positive, and a Group must be nonempty
    * (an empty group has no well-defined bounding box).
    */
  this match
    case Rectangle(w, h) =>
      require(w > 0 && h > 0, s"rectangle dimensions must be positive: $w x $h")
    case Ellipse(rx, ry) =>
      require(rx > 0 && ry > 0, s"ellipse radii must be positive: $rx x $ry")
    case Group(shapes*) =>
      require(shapes.nonEmpty, "a group must contain at least one shape")
    case Location(_, _, _) => ()

end Shape
