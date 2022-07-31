package com.rommelrico.testinginscala

import org.scalacheck.{Gen, Prop, Properties}
import org.scalacheck.Prop._


object VariousGenCheckProperties extends Properties("Various Generators") {
  // Returns 100 constant strings.
  val valueGen = Prop.forAll(Gen.const("Orinoco Flow"))(str => {
    // println(s"str: $str")
    str == "Orinoco Flow"
  })

  // Chooses a value in the given range
  val chooseGen = Prop.forAll(Gen.choose(1, 52))(num => {
    // println(s"num: $num")
    num < 53 && num > 0
  })

  // Randomly selects one of the data sets generated
  val oneOfGen = Prop.forAll(Gen.oneOf(Gen.choose(0, 3), Gen.const("Aretha Franklin")))(x => {
    // println(s"x => $x")
    x match {
      case y: Int => (0 to 3).contains(y)
      case z: String => z == "Aretha Franklin"
    }
  })

  // Generates lists of the size provided
  val listOfNGen = Prop.forAll(Gen.listOfN(4, Gen.choose(20, 60)))(x => {
    // println(s"x => $x")
    (x.size == 4) && (x.sum < 240)
  })

  // Creates random lists with random sizes
  val listOfGen = Prop.forAll(Gen.listOf(Gen.choose(20, 60)))(x => {
    // println(s"x => $x")
    if (x.nonEmpty) x.head > 19 && x.head < 61
    else true
  })

  // Classify will show the distribution of the test data
  val withClassifyGen = Prop.forAll(Gen.listOf(Gen.choose(20, 60)))(x => {
    classify(x.nonEmpty && x.size < 50, "0 to 50") {
      classify(x.size >= 50 && x.size < 100, "50 to 100") {
        classify(x.size >= 100, "100 or more") {
          true
        }
      }
    }
  })

  // Random lists of 1 element
  val listOf1Gen = Prop.forAll(Gen.listOfN(1, Gen.choose(20, 60)))(x => {
    // println(s"x => $x")
    x.nonEmpty
  })

  // Containers other than Lists.
  val containerGen = Prop.forAll(Gen.containerOf[Set, Int](Gen.choose(1, 5)))(x => {
    // println(s"x => $x")
    true
  })

  // Uses a function to generate data
  val resultOfGen = Prop.forAll(Gen.resultOf((x: Int, y: String) => Map(x -> y)))(p => {
    // println(s"p => $p")
    p.isInstanceOf[Map[_, _]]
  })

  // Can specify frequency if you need full control
  val frequencyGen = Prop.forAll(Gen.frequency(
    (3, Gen.const("Phoenix")),
    (2, Gen.const("LCD Soundsystem")),
    (5, Gen.const("JJ"))
  ))(x => {
    // println(s"x => $x")
    classify(x == "Phoenix", "Phoenix") {
      classify(x == "LCD Soundsystem", "LCD Soundsystem") {
        classify(x == "JJ", "JJ") {
          true
        }
      }
    }
  })

  property("Various Gen Check Properties") = valueGen &&
    chooseGen &&
    oneOfGen &&
    listOfNGen &&
    listOfGen &&
    withClassifyGen &&
    listOf1Gen &&
    containerGen &&
    resultOfGen &&
    frequencyGen
}
