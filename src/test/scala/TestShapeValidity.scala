package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows}

import Shape.*

/** Tests for constructor validity checking: shape dimensions must be
  * strictly positive and a group must contain at least one shape.
  */
class TestShapeValidity:

  @Test
  def testZeroWidthRectangleRejected(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Rectangle(0, 5): Unit): Unit

  @Test
  def testNegativeHeightRectangleRejected(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Rectangle(5, -1): Unit): Unit

  @Test
  def testZeroRadiusEllipseRejected(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Ellipse(0, 0): Unit): Unit

  @Test
  def testNegativeRadiusEllipseRejected(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Ellipse(-3, 4): Unit): Unit

  @Test
  def testEmptyGroupRejected(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Group(): Unit): Unit

  @Test
  def testNestedInvalidShapeRejected(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Location(10, 10, Rectangle(-1, 20)): Unit): Unit

  @Test
  def testValidShapesAccepted(): Unit =
    assertEquals(1, size(Rectangle(1, 1)))
    assertEquals(1, size(Ellipse(1, 1)))
    assertEquals(2, size(Group(Rectangle(1, 1), Location(-5, -5, Ellipse(2, 3)))))

end TestShapeValidity
