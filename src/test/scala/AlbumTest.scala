package com.rommelrico.testinginscala

import org.scalatest.funspec.AnyFunSpec

class AlbumTest extends AnyFunSpec {

  describe("An Album") {
    it ("can add an Artist object to the album") {
      val album = new Album("Thriller", 1981, new Artist("Michael", "Jackson"))
    }
  }

}
