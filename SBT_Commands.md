# SBT Commands

* reload
  * Compiles sbt build files
* withSources()
  * Downloads source code for the specific libraries
* withJavadocs()
  * Downloads the documentation for those dependencies.
* Running a specific test
  * `sbt clean compile "test-only com.rommelrico.testinginscala.AlbumTest`
* `--` is meant for calling our tests with options.
* compile
  * Compiles everything under `src/main/scala` and places the class files in `target`.
* clean
  * Removes the target folder
* test:compile
  * Compiles the test classes in `src/test/scala` and places the class files in `target`.
* test
  * Runs all the tests.
* testOnly
  * Runs a list of specified tests delimited by a space.
* package
  * Creates a JAR file of your classes and places it in the `target` folder.


Triggered Execution: `~test`
