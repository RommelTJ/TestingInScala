package com.rommelrico.testinginscala

import org.scalacheck.{Prop, Properties}

object BasicScalaCheckProperties extends Properties("Simple Math") {
  property("Sum is greater than its parts") = Prop.forAll({(x: Int, y: Int) => x + y > x && x + y > y})
}
