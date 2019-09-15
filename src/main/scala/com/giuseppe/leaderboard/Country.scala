package com.giuseppe.leaderboard

case class Country(name: String, populationSize: Int)

case class Countries(
  val allCountries: Map[String, Country] = Map(
    "Russia" -> Country(name = "Russia", populationSize = 1),
    "Germany" -> Country(name = "Germany", populationSize = 1)
  )
)
