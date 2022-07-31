package com.rommelrico.testinginscala

import org.scalacheck.{Arbitrary, Gen, Prop, Properties}

object AlbumCheckImplicitProperties extends Properties("Testing Albums Thoroughly") {
  implicit val album: Arbitrary[Album] = Arbitrary {
    for {
      a <- Gen.alphaStr
      b <- Gen.choose(1900, 2012)
      c <- Gen.alphaStr
    } yield Album(a, b, List(new Artist(c, None, c)))
  }

  property("albums") = {
    Prop.forAll {
      album: Album => {
        // println(s"album2 => $album")
        album.title.isInstanceOf[String]
      }
    }
  }
}
