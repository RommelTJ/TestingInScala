package com.rommelrico.testinginscala

import org.scalatest.flatspec.AnyFlatSpec

class JukeboxUnitSpec extends AnyFlatSpec {

  behavior of "A Jukebox"

  it should
    """have a play method that returns a copy of the jukebox that selects the first song on the
      |first album as the current track""".stripMargin in {
    pending
  }

}
