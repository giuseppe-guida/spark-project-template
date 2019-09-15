  val x :Option[String] = Some("xxxx")
  val XNone: Option[String] = None
  val XNull: Option[String] = null
  val y :String = "yyyy"

  x.getOrElse("") + y

  s"${x.getOrElse("")}${y}" // Not best practice
  x.map( x => x + y )       // Best practice if the the expected parameter is an optional
  if (x.isDefined) x + y

  XNone.map( x => x + y )   // Same result as above
  XNull.map( x => x + y )
