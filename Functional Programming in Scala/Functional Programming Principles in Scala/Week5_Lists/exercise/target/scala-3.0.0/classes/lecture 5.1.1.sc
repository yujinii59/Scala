val fruits = List("Apple","Orange","Banana")
val nums = 1 :: 2 :: 3 :: 4 :: Nil

fruits.head
nums.tail
nums.isEmpty

nums match
  case x :: y :: _ => x + y

// the number of elements of nums
nums.length
// the list's last element, exception if nums is empty
nums.last
// a list consisting of all elements of nums except the last one, exception if nums is empty
nums.init
// a list consisting of the first n elements of nums if it it shorter than n
nums.take(2)
// the rest of the collection after taking n elements
nums.drop(2)
// the element of nums at index n
nums(1)
nums.apply(1)

// the list consisting of all elements of nums followed by all elements of fruits
nums ++ fruits
// the list containing the elements of nums in reversed order
nums.reverse
// the list containing the same elements as nums, except at index n where it contains x
nums.updated(2, 8)

// the index of the first element in nums equal to x, or -1 if x does not appear in nums
nums.indexOf(2)
// same as nums.indexOf(x) >= 0 , if nums contains x then true, another is false
nums.contains(2)