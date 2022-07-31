package com.rommelrico.testinginscala

case class Album(title: String, year: Int, artists: List[Artist]) {
  if (artists.isEmpty) throw new IllegalArgumentException("An album must have an artist")
}
