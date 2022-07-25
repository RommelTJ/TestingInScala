# Mocking

* Mocking terms from Martin Fowler
  * Dummy
    * An object that does nothing but fill space.
    * Calls made to a dummy won't change anything.
  * Stub
    * An object that consumes test behavior and generates some result.
    * It is meant to pre-create answers for tests.
  * Fake
    * A real object that overrides the more difficult stuff by providing a shortcut.
  * Mock
    * An object that is given orders to carry out a prescribed set of commands.
* EasyMock
  * Works by
    1. creating the mock, 
    2. rehearsing the mock with expected behavior, 
    3. rewinding the behavior back to the beginning, and 
    4. sending the mock into the test method to act out what was rehearsed
  * ScalaTest offers an EasyMockSugar trait that makes replaying and verifying easier
* Mockito
  * Mockito is like EasyMock but mocks don't have to be replayed
  * Mockito offers Hamcrest integration so that each parameter can have a wild card parameter
  * Works in ScalaTest and Specs2
    * But for Specs2 it requires special tweaking.
* ScalaMock
  * A testing framework designed for scala
  * Can test Scala functions, singletons, companion objects, static methods, final objects, and final methods
  * Requires you to install via Build.scala instead of plan build.sbt
    * autoCompilerPlugins
      * Turns on the compiler plugin functionality
    * addCompilerPlugin
      * Specifies which compiler plugin to use
    * scalacOptions
      * Compilation flags for the Scala compiler.
  * Can mock traits
  * Can mock concrete classes
  * Can mock singleton objects
  * Can mock companion objects
  * Can mock functions
  * Can mock final objects and methods
