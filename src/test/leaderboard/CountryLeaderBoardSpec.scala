package com.giuseppe.leaderboard

import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

class CountryLeaderBoardSpec extends FlatSpec with MockFactory {
  val countryLeaderBoardMock = mock[CountryLeaderboard]

  // set expectations
  (countryLeaderBoardMock.addVictoryForCountry _).expects(Countries().allCountries("Germany")) //Expected value

  // use countryLeaderBoardMock
  countryLeaderBoardMock.addVictoryForCountry(Countries().allCountries("Germany")) // OK
  countryLeaderBoardMock.addVictoryForCountry(Countries().allCountries("Russia"))  // throws TestFailedException
}
