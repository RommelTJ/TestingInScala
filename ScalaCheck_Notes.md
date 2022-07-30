# ScalaCheck

* ScalaCheck fully automates test generation so that you don't have to create test data.
* ScalaCheck generates semi-random data within the parameters you request.
* There are 3 main components to ScalaCheck:
  1. The `Properties` class.
     1. Defines tests and runs them through a test harness called `Prop`.
     2. `Properties` can be mixed and matched with various groupings and combinations.
     3. `Properties` can be filtered to provide data only needed for the test.
  2. The `Gen` object.
     1. A Generator class that provides much of the fake data and allows you to control the kind of data created.
  3. The `Arbitrary` class.
     1. Used for custom types.
* ScalaCheck integrates with ScalaTest and Specs2.
* To install: `libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.16.0" % "test"`

## Properties

* The ScalaCheck test harness is the Prop, and the testing class is a collection of Properties.
* To create a ScalaCheck test, create an object that extends Properties.
* A Properties test must be an object (Scala Singleton), not a class.
* Each property takes a String to describe the purpose of the test.
  * The left side of the assignment is the property specifier.
  * The right side is the actual Prop test.

## Constraining Properties

* You can constrain properties. See code example.
* Conditional properties are filters where you stipulate what is considered good data for the test.

## Grouping Properties

* A Properties object can contain one or more property tests.
* Prop objects can also be combined to craft a larger composed Prop.
* Generator functions:  
  * `Gen.value`
    * Returns the value that it contains.
    * Ex: `Gen.value("test")` returns `"test"`
  * `Gen.chooses`
    * Provides a value in a range between two items, inclusively.
    * Ex: `Gen.choose(1, 52)` returns random numbers between 1 and 52.
  * `Gen.oneOf`
    * Wraps other Gen objects and randomly selects one for each data set generated.
    * Ex: `Gen.oneOf(Gen.choose(-2, 3), Gen.value("Aretha Franklin"))` can generate either
      * A number from -2 to 3, or
      * The string "Aretha Franklin"
  * `Gen.listOfN`
    * Generates a list of the size provided in its first parameter, containing random values.
    * Ex: `Gen.listOfN(4, Gen.choose(20, 60))` returns lists of 4 elements, where 
      each element is a number between 20 and 60
  * `Gen.listOf`
    * Creates a random lists with random sizes.
    * Ex: `Gen.listOf(Gen.choose(20, 60))` returns varying-sized lists of numbers from 20 to 60.
  * `Gen.listOf1`
    * Creates randomly generated list with at least one element.
    * Ex: `Gen.listOf1(Gen.choose(20, 60))` returns lists of 1 element between 20 and 60.
  * `Gen.containerOf`
    * Creates containers of other types, not just lists.
    * Ex: `Gen.containerOf[Set, Int](Gen.choose(1, 5))` returns sets with numbers between 1 and 5
    * CAREFUL: Containers can be tricky because some collections will not allow duplicates.
  * `Gen.resultOf`
    * Generates values using a function.
    * Ex: `Gen.resultOf((x: Int, y: String) => Map(x -> y))` returns values based on the provided function. 
      ScalaCheck generates the parameters.
* Options for ScalaCheck
  * Can be used at the command prompt or in SBT.
  * `-maxSize` or `x`
    * Maximum size of the data generated
  * `-maxDiscardedTests` or `-d`
    * Number of tests that can be discarded before ScalaCheck stops testing a property
  * `-verbosity` or `-v`
    * Verbosity level
  * `-workers` or `-w`
    * Number of threads to execute in parallel for testing
  * `-minSuccessfulTests` or `-s`
    * Number of tests that must succeed in order to pass a property
  * `-minSize` or `-n`
    * Minimum data generation size

## Custom Generators

* Custom generators in ScalaCheck are typically done in a for-loop.
* See code examples.
* In Scala, for-loops always resort to flatMap, map, and filter to do their calculations and do so based on the 
  initial expression of the for-loop.

## Arbitrary

* Arbitrary uses Scala's implicit variables and methods so these values can always be available without any added programming.
* See code examples.
* The variable album is implicit, which means that it is available in scope for anything that requires that type of signature.

## Labeling

* Tests in ScalaCheck can have labels appended to each assertion.

## ScalaCheck with Specs2

* You can use ScalaCheck with specs2.
