
// Example from a story in the

val sourcesMap: Map[String, Int] = Map(
  "FILE" -> 1,
  "WEBUPDATER" -> 2,
  "FUZZIT" -> 3,
  "DEX" -> 4
)

val separator = "-"
val sourceArr = "FILE,WEBUPDATER,whatever".split(",")
val sourceIdArr = sourceArr.flatMap(sourcesMap.get).mkString("-")
if(!sourceIdArr.isEmpty) s"$separator" + sourceIdArr + s"$separator"

if(!"".isEmpty) 1