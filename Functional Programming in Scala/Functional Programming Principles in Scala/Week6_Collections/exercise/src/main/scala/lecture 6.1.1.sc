val nums = Vector(1, 2, 3, -88)
val people = Vector("Bob", "James", "Peter")

nums +: people
nums :+ people

1 +: nums
people :+ "Tom"

val test = List(1,2,3,4)
0 +: test

val xs: Array[Int] = Array(1, 2, 3)
xs.map(x => 2 * x)

val ys: String = "Hello World!"
ys.filter(_.isUpper)

val r: Range = 1 until 5
val s: Range = 1 to 5
1 to 10 by 3
6 to 1 by -2

xs.exists(x => x >= 3)
xs.forall(x => x < 3)
val zip_arr = xs.zip(people)
zip_arr.unzip
test.sum
test.product
test.max
test.min