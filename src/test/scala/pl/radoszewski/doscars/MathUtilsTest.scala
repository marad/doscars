package pl.radoszewski.doscars

import org.specs2.mutable.Specification

class MathUtilsTest extends Specification {
  "MathUtils" should {
    "rotate vector by angle" in {
      val vec = MathUtils.rotateVector(0, 1, 90)

      vec.x must be equalTo -1
      vec.y must be equalTo 0
    }
  }

}
