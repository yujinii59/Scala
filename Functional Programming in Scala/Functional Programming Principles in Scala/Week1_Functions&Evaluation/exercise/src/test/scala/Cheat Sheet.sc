val fruitList = List("apples", "oranges", "pears")
val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
fruit.head
fruit.tail

val empty = List()
val empty = Nil

val nums = Vector("louis","frank","hiromi")
nums(1)
nums.updated(2, "helena")

val fruitSet = Set("apple","banana","pear","banana")
fruitSet.size

val r: Range = 1 until 5
val s: Range = 1 to 5
1 to 10 by 3
6 to 1 by -2

val s = (1 to 6).toSet
s.map(_ + 2)

val s = "Hello World"
s.filter(c => c.isUpper)

val xs = List("1","2","3")
xs.length         // number of elements, complexity O(n)
xs.last           // last element (exception if xs is empty), complexity O(n)
xs.init           // all elements of xs but the last (exception if xs is empty), complexity O(n)
val n = 0
xs.take(n)        // first n elements of xs
xs.drop(n)        // the rest of the collection after taking n elements
xs.splitAt(n)     // same as (xs take n, xs drop n)
xs(n)             // the nth element of xs, complexity O(n)
val ys = List("a","b","c")
xs ++ ys          // concatenation, complexity O(n)
xs.reverse        // reverse the order, complexity O(n)
val x = "9"
xs.updated(n, x)  // same list than xs, except at index n where it contains x, complexity O(n)
xs.indexOf(x)     // the index of the first element equal to x (-1 otherwise)
xs.contains(x)    // same as xs indexOf x >= 0
xs.filter(p)      // returns a list of the elements that satisfy the predicate p
xs.filterNot(p)   // filter with negated p
xs.partition(p)   // same as (xs filter p, xs filterNot p)
xs.takeWhile(p)   // the longest prefix consisting of elements that satisfy p
xs.dropWhile(p)   // the remainder of the list after any leading element satisfying p have been removed
xs.span(p)        // same as (xs takeWhile p, xs dropWhile p)