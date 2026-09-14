package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*

/** Tests for the height behavior. A leaf shape has height 1;
  * Location and Group each contribute one additional level.
  */
class TestHeight:

  def testHeight(s: Shape, expected: Int): Unit =
    assertEquals(expected, height(s))

  @Test
  def testSimpleRectangle(): Unit =
    testHeight(simpleRectangle, 1)

  @Test
  def testSimpleEllipse(): Unit =
    testHeight(simpleEllipse, 1)

  @Test
  def testSimpleLocation(): Unit =
    testHeight(simpleLocation, 2)

  @Test
  def testBasicGroup(): Unit =
    testHeight(basicGroup, 2)

  @Test
  def testSimpleGroup(): Unit =
    testHeight(simpleGroup, 3)

  @Test
  def testComplexGroup(): Unit =
    testHeight(complexGroup, 6)

end TestHeight
