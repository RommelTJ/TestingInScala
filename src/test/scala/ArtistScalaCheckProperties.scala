package com.rommelrico.testinginscala

import org.scalacheck.{Prop, Properties}

object ArtistScalaCheckProperties extends Properties("Testing Artists Thoroughly") {
  property("middleNames") = {
    Prop.forAll((firstName: String, middleNameOpt: Option[String], lastName: String) => {
      middleNameOpt match {
        case Some(middleName) =>
          val artist = new Artist(firstName, Some(middleName), lastName)
          artist.fullName == firstName + " " + middleName + " " + lastName
        case _ =>
          val artist = new Artist(firstName = firstName, lastName = lastName)
          artist.fullName == firstName + " " + lastName
      }
    })
  }
}
