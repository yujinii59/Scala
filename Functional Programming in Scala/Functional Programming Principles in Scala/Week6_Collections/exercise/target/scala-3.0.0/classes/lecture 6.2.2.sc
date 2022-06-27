case class Person(name: String, age: Int)

val persons = List(Person("A1", 20), Person("A2", 40), Person("A3", 34), Person("A4", 12), Person("A5", 23), Person("A6", 51), Person("A7", 7), Person("A8", 19))
for p <- persons if p.age > 20 yield p.name

persons
  .filter(p => p.age > 20)
  .map(p => p.name)