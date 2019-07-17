val x = List(1, 2, 3, 4, 5)

def foo(i: Int)(x: Int) = {
  println(i+x)
  i + x
}

x.foreach {
  foo(2)
  println("giuseppe")
}

