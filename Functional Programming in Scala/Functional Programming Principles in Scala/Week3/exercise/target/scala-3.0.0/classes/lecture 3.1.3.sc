// companions : class and object with the same name are given in the same sourcefile

class IntSet:
  object IntSet:
    def singleton(x: Int) = NonEmpty(x, Empty, Empty)



// standalone applications
object Hello:
  def main(args: Array[String]): Unit = println("hello world!")

    // > scala Hello   ---> hello world!

@main def birthday(name: String, age: Int) =
  println(s"Happy birthday, $name! $age years old already!")

    // > scala birthday Peter 11   ---> Happy birthday, Peter! 11 years old already!
