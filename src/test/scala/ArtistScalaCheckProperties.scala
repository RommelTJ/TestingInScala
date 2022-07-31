package com.rommelrico.testinginscala

import org.scalacheck.{Gen, Prop, Properties}

object ArtistScalaCheckProperties extends Properties("Testing Artists Thoroughly") {
  property("middleNames") = {
    Prop.forAll(Gen.alphaStr, Gen.oneOf(Gen.alphaStr.sample, None), Gen.alphaStr) {
      (firstName: String, middleNameOpt: Option[String], lastName: String) => {
        // println(firstName, middleNameOpt, lastName)
        middleNameOpt match {
          case Some(middleName) =>
            val artist = new Artist(firstName, Some(middleName), lastName)
            artist.fullName == firstName + " " + middleName + " " + lastName
          case _ =>
            val artist = new Artist(firstName = firstName, lastName = lastName)
            artist.fullName == firstName + " " + lastName
        }
      }
    }
  }
}
