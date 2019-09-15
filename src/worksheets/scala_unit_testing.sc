import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

object CubeCalculator extends App {
  def cube(x: Int) = {
    x * x * x
  }
}

class CubeCalculatorTest extends FunSuite {
  test("CubeCalculator.cube") {
    assert(CubeCalculator.cube(3) === 27)
  }
}

import org.scalatest.FunSuite

class Test01 extends FunSuite {
  test("Very Basic") {
    assert(1 == 1)
  }
  test("Another Very Basic") {
    assert("Hello World" == "Hello World")
  }
}