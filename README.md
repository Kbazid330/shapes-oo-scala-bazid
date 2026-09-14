# shapes-oo-scala

COMP 371 Project 1a — shapes as an algebraic data type in Scala 3.

## Behaviors

- `boundingBox` — smallest axis-aligned box containing a shape
- `size` — number of concrete leaf shapes (rectangles and ellipses)
- `height` — height of the shape tree; a leaf has height 1, and
  `Location` and `Group` each add one level
- `scale` — recursively scales all dimensions and locations by a factor

Shape constructors reject nonpositive dimensions and empty groups.

## Running

    sbt test
    sbt "Test/runMain edu.luc.cs.laufer.cs371.shapes.Main"

Debug logging (SLF4J + Logback) is off by default and enabled at runtime
without recompiling:

    sbt -Dshapes.log.level=DEBUG "Test/runMain edu.luc.cs.laufer.cs371.shapes.Main"

## Extra credit

Neither extra credit task (graphical rendering via Doodle, or automated
testing of a `draw` behavior) was attempted.

## AI usage

Claude was used on this project; the transcript is in `doc/claude-conversation.md`.
