package com.rommelrico.testinginscala

import org.scalatest.{GivenWhenThen, Tag}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.flatspec.AnyFlatSpec


object CustomTag extends Tag("com.rommelrico.tags.CustomTag")

class AlbumTest extends AnyFunSpec with Matchers with GivenWhenThen {

  describe("An Album") {
    it ("can add an Artist object to the album", testTags = CustomTag) {
      info("Making sure Michael Jackson is the artist of Thriller")
      Given("The album Thriller by Michael Jackson")
      val album = new Album("Thriller", 1981, List(new Artist("Michael", "Jackson")))

      When("The album's artist is obtained")
      val artists = album.artists

      Then("the artist obtained should be an instance of Artist")
      artists.head.isInstanceOf[Artist] should be(true)

      And("The artist's first name should be Michael and last name should be Jackson")
      artists.head.firstName should be("Michael")
      artists.head.lastName should be("Jackson")
    }

    it ("throw an Exception if there are no acts when created", testTags = CustomTag) {
      intercept[IllegalArgumentException] {
        new Album("The Joy of listening to nothing", 1980, List())
      }
    }

    it ("throw an exception if there are not artists when created", CustomTag) {
      val thrownException = the [IllegalArgumentException] thrownBy (new Album("The Joy of listening to nothing", 1980, List()))
      thrownException.getMessage should equal("An album must have an artist")
    }

    it ("can add opt to not have any artists at construction time", CustomTag) { pending }

    ignore("can add a producer to an album at constructor time", CustomTag) {
      new Album("Breezin", 1976, List(new Artist("George", "Benson")))
      // TODO: Figure out this hypothetical test.
    }

  }

}
