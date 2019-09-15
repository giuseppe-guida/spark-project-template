package com.giuseppe.leaderboard

object Player {
  type PlayerId = Int
}

case class Player(id: Player.PlayerId, nickname: String, country: Country)