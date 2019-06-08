val ints = 0 to 10
def printEach[T](iterable: Iterable[T]): Unit = iterable.foreach(print)
def printlnEach[T](iterable: Iterable[T]): Unit = iterable.foreach(println)

printEach(ints)
