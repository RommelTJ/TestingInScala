# ScalaTest Notes

* To set up triggered execution.
  * Go to sbt shell
  * Type `~testOnly`
* To run a specific test
  * Go to sbt shell
  * Type `testOnly *AlbumTest`
* `test` runs all tests.
* `testOnly` runs a list of tests delimited by a space.
* To include tests with a tag: 
  * `~testOnly com.rommelrico.* -- -n "com.rommelrico.tags.CustomTag"`
* To exclude tests with a tag:
  * `~testOnly com.rommelrico.* -- -l "com.rommelrico.tags.CustomTag"`
* `Should` and `Must` matchers are equivalent
* Exception Handling
  * There are two ways.
  * One is to place the volatile code in an intercept block.
  * The other is to use a Should or Must matcher to assets the call throws an exception.
* Informers
  * Informers are spices analogous to debug statements.
* GivenWhenThen
  * Given(""), When(""), Then(""), And("")
* Pending Tests
  * You can mark a test as pending as a placeholder.
* Ignoring Tests
  * You can mark a test as ignored with ignore.

## Specifications

### AnyFunSpec

Facilitates a "behavior-driven" style of development (BDD), in which tests are combined with text that specifies 
the behavior the tests verify.

Here's an example AnyFunSpec:
```scala
package org.scalatest.examples.funspec

import org.scalatest.funspec.AnyFunSpec

class SetSpec extends AnyFunSpec {
  describe("A Set") {
    describe("when empty") {
      it("should have size 0") {
        assert(Set.empty.size === 0)
      }
      
      it("should produce NoSuchElementException when head is invoked") {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }
}
```

### AnyWordSpec

Class AnyWordSpec is so named because your specification text is structured by placing words after strings.

```scala
package org.scalatest.examples.wordspec

import org.scalatest._

class SetSpec extends wordspec.AnyWordSpec {
  "A Set" when {
    "empty" should {
      "have size 0" in {
        assert(Set.empty.size === 0)
      }

      "produce NoSuchElementException when head is invoked" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }
}
```

### AnyFeatureSpec

A suite of tests in which each test represents one scenario of a feature. AnyFeatureSpec is intended for writing tests 
that are "higher level" than unit tests, for example, integration tests, functional tests, and acceptance tests. You 
can use AnyFeatureSpec for unit testing if you prefer, however.

```scala
package org.scalatest.examples.featurespec

import org.scalatest._

class TVSet {
 private var on: Boolean = false
 def isOn: Boolean = on
 def pressPowerButton() {
   on = !on
 }
}

class TVSetSpec extends featurespec.AnyFeatureSpec with GivenWhenThen {

 info("As a TV set owner")
 info("I want to be able to turn the TV on and off")
 info("So I can watch TV when I want")
 info("And save energy when I'm not watching TV")

 Feature("TV power button") {
   Scenario("User presses power button when TV is off") {

     Given("a TV set that is switched off")
     val tv = new TVSet
     assert(!tv.isOn)

     When("the power button is pressed")
     tv.pressPowerButton()

     Then("the TV should switch on")
     assert(tv.isOn)
   }

   Scenario("User presses power button when TV is on") {
     Given("a TV set that is switched on")
     val tv = new TVSet
     tv.pressPowerButton()
     assert(tv.isOn)

     When("the power button is pressed")
     tv.pressPowerButton()

     Then("the TV should switch off")
     assert(!tv.isOn)
   }
 }
}
```

### FreeSpec

Facilitates a "behavior-driven" style of development (BDD), in which tests are nested inside text clauses 
denoted with the dash operator (-).

AnyFreeSpec is so named because unlike classes such as AnyWordSpec, AnyFlatSpec, and AnyFunSpec, it is enforces no 
structure on the text. You are free to compose text however you like. (A AnyFreeSpec is like free-verse poetry as 
opposed to a sonnet or haiku, which defines a structure for the text of the poem.)

```scala
package org.scalatest.examples.freespec

import org.scalatest.freespec.AnyFreeSpec

class SetSpec extends AnyFreeSpec {

 "A Set" - {
   "when empty" - {
     "should have size 0" in {
       assert(Set.empty.size === 0)
     }

     "should produce NoSuchElementException when head is invoked" in {
       assertThrows[NoSuchElementException] {
         Set.empty.head
       }
     }
   }
 }
}
```

### AnyFlatSpec

Facilitates a "behavior-driven" style of development (BDD), in which tests are combined with text that specifies the 
behavior the tests verify.

Recommended Usage: Class AnyFlatSpec is a good first step for teams wishing to move from xUnit to BDD, because its 
structure is flat like xUnit, so simple and familiar, but the test names must be written in a specification style: 
“X should Y,” “A must B,” etc.

Trait AnyFlatSpec is so named because your specification text and tests line up flat against the left-side indentation 
level, with no nesting needed.

Note: you can use must or can as well as should in a AnyFlatSpec. For example, instead of it should "have..., you could 
write it must "have... or it can "have....

Instead of using a behavior of clause, you can alternatively use a shorthand syntax in which you replace the first it 
with the subject string.

```scala
package org.scalatest.examples.flatspec

import org.scalatest.flatspec.AnyFlatSpec

class SetSpec extends AnyFlatSpec {

 behavior of "An empty Set"

 it should "have size 0" in {
   assert(Set.empty.size === 0)
 }

 it should "produce NoSuchElementException when head is invoked" in {
   assertThrows[NoSuchElementException] {
     Set.empty.head
   }
 }
}
```

### Other Specs

* JUnitTestSuite
* TestNGSuite

## Fixtures

* You can implement fixtures using Scala features
* or you can use something like `OneInstancePerTest`, `before`, `after`.
