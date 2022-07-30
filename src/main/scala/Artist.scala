package com.rommelrico.testinginscala

class Artist(val firstName: String, val middleName: Option[String] = None, val lastName: String) {
  def fullName: String = {
    val nameParts: Seq[String] = middleName.map(m => Seq(firstName, m, lastName)).getOrElse(Seq(firstName, lastName))
    nameParts.mkString(" ")
  }
}
