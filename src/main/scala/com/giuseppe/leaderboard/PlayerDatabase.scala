package com.giuseppe.leaderboard

trait PlayerDatabase {
  def getPlayerById(playerId: Player.PlayerId): Player
}

class FakePlayerDatabase extends PlayerDatabase {
  override def getPlayerById(playerId: Player.PlayerId): Player = {
    if (playerId == 222) return Player(222, "boris", Countries().allCountries("Russia"))
    else if (playerId == 333) return Player(333, "hans", Countries().allCountries("Russia"))
    else ???
  }
}
