def sumInts(a: Int, b: Int): Int =
  if a > b then 0 else a + sumInts(a + 1, b)

def cube(x: Int): Int = x * x * x

def sumcubes(a: Int, b: Int): Int =
  if a > b then 0 else cube(a) + sumcubes(a + 1, b)

def fact(x: Int): Int =
  if x == 0 then 1 else x * fact(x - 1)

def sumFactorials(a: Int, b: Int): Int =
  if a > b then 0 else fact(a) + sumFactorials(a + 1, b)

