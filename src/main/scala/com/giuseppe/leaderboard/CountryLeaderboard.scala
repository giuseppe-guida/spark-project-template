package com.giuseppe.leaderboard

case class CountryLeaderboardEntry(country: Country, points: Int)

trait CountryLeaderboard {
  def addVictoryForCountry(country: Country): Unit
  def getTopCountries(): List[CountryLeaderboardEntry]
}