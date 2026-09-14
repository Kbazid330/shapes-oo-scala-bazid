package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows}

import TestFixtures.*
import Shape.*

/** Tests for the scale behavior. Scaling multiplies every dimension and
  * location by the factor, so the bounding box scales by the same factor
  * while the tree structure (size and height) is unchanged.
  */
class TestScale:

  def testScaledBoundingBox(s: Shape, factor: Int, x: Int, y: Int, width: Int, height: Int): Unit =
    val Location(u, v, Rectangle(w, h)) = boundingBox(scale(factor)(s)) : @unchecked
    assertEquals(x, u)
    assertEquals(y, v)
    assertEquals(width, w)
    assertEquals(height, h)

  @Test
  def testSimpleRectangle(): Unit =
    assertEquals(Rectangle(240, 360), scale(3)(simpleRectangle))

  @Test
  def testSimpleEllipse(): Unit =
    assertEquals(Ellipse(100, 60), scale(2)(simpleEllipse))

  @Test
  def testSimpleLocation(): Unit =
    assertEquals(Location(140, 60, Rectangle(160, 240)), scale(2)(simpleLocation))

  @Test
  def testBasicGroup(): Unit =
    testScaledBoundingBox(basicGroup, 2, -100, -60, 200, 140)

  @Test
  def testSimpleGroup(): Unit =
    testScaledBoundingBox(simpleGroup, 3, 450, 210, 1050, 840)

  @Test
  def testComplexGroup(): Unit =
    testScaledBoundingBox(complexGroup, 5, 150, 300, 2350, 1600)

  @Test
  def testIdentityScaling(): Unit =
    assertEquals(complexGroup, scale(1)(complexGroup))

  @Test
  def testStructurePreserved(): Unit =
    val scaled = scale(4)(complexGroup)
    assertEquals(size(complexGroup), size(scaled))
    assertEquals(height(complexGroup), height(scaled))

  @Test
  def testNonPositiveFactorRejected(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => scale(0)(simpleRectangle): Unit): Unit

end TestScale
