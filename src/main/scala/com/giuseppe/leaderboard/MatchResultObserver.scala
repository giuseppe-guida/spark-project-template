package com.giuseppe.leaderboard

class MatchResultObserver(playerDatabase: PlayerDatabase, countryLeaderBoard: CountryLeaderboard) {
  def recordMatchResult(result: MatchResult): Unit = {
    val player = playerDatabase.getPlayerById(result.winner)
    countryLeaderBoard.addVictoryForCountry(player.country)
  }
}

// https://scalamock.org/quick-start/