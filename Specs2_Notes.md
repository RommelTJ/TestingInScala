# Specs2 Notes

* Sames as ScalaTest but
  * Different set of matchers
  * Different way of structuring tests
  * DataTable specifications
  * AutoExamples
  * Fitnesse style specifications
  * Tests are executed concurrently in each thread.
* Specifications
  * UnitSpec
    * A string followed by the word should
* Matchers
  * Simple
  * String
  * Relational Operator
  * Floating-point
  * Reference
  * Iterable
  * Seq and Traversable
  * Map
  * XML
  * Partial and Function
* Acceptance Specification
  * Separates what the test is expected to do from what actually happens during the test.
* Chaining tests
  * Tests in Specs2 can be chained.
* Given/When/Then
  * Used in AcceptanceSpec to hold state.
* Data Tables
  * ASCII Tables that contain sample values and end result
* Tagging
  * Specs2 also has tagging.
* Fixtures
  * Specs2 relies on Scala to implement Fixtures.
* Should you use Scalatest or Specs2?
  * ScalaTest, because it's easier to use.
  * ScalaTest has more stars on GitHub.
