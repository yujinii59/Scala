def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
def fact(x: Int): Int = if x == 0 then 1 else x * fact(x - 1)

def sum(f: Int => Int, a: Int, b: Int): Int =
  if a > b then 0
  else f(a) + sum(f, a - 1, b)

def sumInts(a: Int, b: Int) = sum(id, a, b)
def sumCubes(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(fact, a, b)


// anonymous function
//(x: Int) => x * x * x
//(x: Int, y: Int) => x + y

//def f(x: Int, y: Int) = x + y;f

// apply anonymous function
def sumInts2(a: Int, b: Int) = sum(x => x, a, b)
def sumCubes2(a: Int, b: Int) = sum(x => x * x * x, a, b)

