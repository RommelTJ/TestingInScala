package com.rommelrico.testinginscala

import org.scalacheck.{Gen, Prop, Properties}

object AlbumCheckProperties extends Properties("Testing Albums Thoroughly") {
  val albums = for {
    a <- Gen.alphaStr
    b <- Gen.choose(1900, 2012)
    c <- Gen.alphaStr
  } yield Album(a, b, List(new Artist(c, None, c)))

  property("albums") = {
    Prop.forAll(albums)(album => {
      // println(s"album => $album")
      album.title.isInstanceOf[String]
    })
  }
}
