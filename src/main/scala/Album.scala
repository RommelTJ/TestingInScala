package com.rommelrico.testinginscala

class Album(val title: String, val year: Int, val artists: List[Artist]) {
  if (artists.isEmpty) throw new IllegalArgumentException("An album must have an artist")
}
