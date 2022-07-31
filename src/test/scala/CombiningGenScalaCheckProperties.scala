package com.rommelrico.testinginscala

import org.scalacheck.{Gen, Prop, Properties}
import org.scalacheck.Prop._

object CombiningGenScalaCheckProperties extends Properties("Combining Properties") {
  val stringsOnly = Prop.forAll(Gen.alphaStr) {
    x: String => (x != "") ==> x.size >= 0
  }
  val positiveNumbersOnly = Prop.forAll(Gen.posNum[Int]) {
    x: Int => x >= 0
  }
  val positiveNumbers2Only = Prop.forAll(Gen.posNum[Int]) {
    x: Int => x > 0
  }
  val alwaysPass = Prop.forAll {
    x: Int => true
  }
  val wontPass = Prop.forAll((x: Int, y: Int) => x + y > 0)

  property("And") = stringsOnly && positiveNumbersOnly
  property("Or") = stringsOnly || wontPass
}
