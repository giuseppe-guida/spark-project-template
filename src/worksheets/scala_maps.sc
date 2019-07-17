val m = Map(
  "hasEmailOptin" -> "hasEmailOptinDate",
  "hasEmailDoubleOptIn" -> "hasEmailDoubleOptInDate",
  "hasMobileOptin" -> "hasMobileOptinDate",
  "hasMobileDoubleOptIn" -> "hasMobileDoubleOptInDate"
)

val x = m.flatMap(t => List(t._1, t._2))

m.keySet
m("hasEmailOptin")
m.valuesIterator.toList


// MAPS OF MAPS

case class channelConsent(
  optInFields: List[String] = List(),
  optOutFields: List[String] = List(),
  sortingDateFields: List[String] = List(),
  furtherSortingDateFields: List[String] = List()
)

val m2 = Map(
  "email" -> channelConsent(optInFields=List("hasEmailOptIn", "asdfasdf")),
  "mobile" -> channelConsent(optInFields=List("sdfasdf"))
)

m2("email").optInFields

