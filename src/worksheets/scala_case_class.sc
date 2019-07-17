case class Foo(a: Int, b: String, c: Double)
Foo(1, "bar", 3.14).productIterator.toList

case class ConsentColumns(flag: String, date: String)

val consentFieldsByTopic = List(
  ConsentColumns("hasEmailOptin", "hasEmailOptinDate"),
  ConsentColumns("hasEmailDoubleOptIn", "hasEmailDoubleOptInDate"),
  ConsentColumns("hasMobileOptin", "hasMobileOptinDate"),
  ConsentColumns("hasMobileDoubleOptIn", "hasMobileDoubleOptInDate")
)

val excludeFields = Seq(
    List("group_row_num") :::
    consentFieldsByTopic.flatMap(
      t => t.productIterator.toList ::: t.productIterator.toList
    )
)

println(Foo)
// EXTENDING A CASE CLASS - not possible

println(Foo)