package com.giuseppe.leaderboard

import org.scalatest.FlatSpec
import org.scalamock.scalatest.MockFactory

class PlayerDatabaseSpec extends FlatSpec with MockFactory{
  // create fakeDb stub that implements PlayerDatabase trait
  val fakeDb = stub[PlayerDatabase]

  // configure fakeDb behavior
  (fakeDb.getPlayerById _) when(222) returns(Player(222, "boris", Countries().allCountries("Russia")))
  (fakeDb.getPlayerById _) when(333) returns(Player(333, "hans", Countries().allCountries("Germany")))

  // use fakeDb
  assert(fakeDb.getPlayerById(222).nickname == "boris")
}
