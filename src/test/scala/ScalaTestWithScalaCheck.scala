package com.rommelrico.testinginscala

import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec
import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class ScalaTestWithScalaCheck extends AnyFlatSpec with Matchers with ScalaCheckDrivenPropertyChecks {
  behavior of "Test data with Scala Check"

  it should "run constraints but differently" in {
    forAll(Gen.choose(1, 100), Gen.choose(1, 100)) {
      (a: Int, b: Int) =>
        // println(s"a: $a; b: $b;")
        (a + b) should be (b + a)
    }
  }
}
