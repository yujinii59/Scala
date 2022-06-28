val rand = java.util.Random()
rand.nextInt()


trait Generator[+T]:
  def generate(): T

extension [T, S](g: Generator[T])
//  def map(f: T => S) = new Generator[S]:
//    def generate() = f(g.generate())

  def map[S](f: T => S) = new Generator[S]:
    def generate() = f(Generator.this.generate())

//  def flatMap(f: T => Generator[S]) = new Generator[S]:
//    def generate() = f(g.generate()).generate()

  def flatMap[S](f: T => Generator[S]) = new Generator[S]:
    def generate() = f(Generator.this.generate()).generate()

val integers: Generator[Int] = new Generator[Int]:
  val rand = java.util.Random()
  def generate() = rand.nextInt()

//val booleans = new Generator[Boolean]:
//  def generate() = integers.generate() > 0

//val booleans = for x <- integers yield x > 0

//val booleans = integers.map(x => x > 0)

//val booleans = new Generator[Boolean]:
//  def generate() = ((x: Int) => x > 0)(integers.generate())

val booleans = new Generator[Boolean]:
  def generate() = integers.generate() > 0

//val pairs = new Generator[(Int, Int)]:
//  def generate() = (integers.generate(), integers.generate())

//def pairs[T, U](t: Generator[T], u: Generator[U]) =
//  for x <- t; y <- u yield (x, y)

//def pairs[T, U](t: Generator[T], u: Generator[U]) =
//  t.flatMap(x => u.map(y => (x, y)))

//def pairs[T, U](t: Generator[T],  u: Generator[U]) =
//  t.flatMap(x => new Generator[(T, U)] { def generate() = (x, u.generate())})

//def pairs[T, U](t: Generator[T], u: Generator[U]) = new Generator[(T, U)]:
//  def generate() = (new Generator[(T, U)]{
//    def generate() = (t.generate(), u.generate())
//  }).generate()

def pairs[T, U](t: Generator[T], u: Generator[U]) = new Generator[(T, U)]:
  def generate() = (t.generate(), u.generate())

pairs.generate()


def single[T](x: T): Generator[T] = new Generator[T]:
  def generate() = x

def range(lo: Int, hi: Int): Generator[Int] =
  for x <- integers yield lo + x.abs % (hi - lo)

def oneOf[T](xs: T*): Generator[T] =
  for idx <- range(0, xs.length) yield xs(idx)

val choice = oneOf("red","green","blue")
choice.generate()

def lists: Generator[List[Int]] =
  for
    isEmpty <- booleans
    list <- if isEmpty then emptyLists else nonEmptyLists
  yield list

def lists: Generator[List[Int]] =
  for
    kind <- range(0, 5)
    list <- if kind == 0 then emptyLists else nonEmptyLists
  yield list

def emptyLists = single(Nil)

def nonEmptyLists =
  for
    head <- integers
    tail <- lists
  yield head :: tail

lists.generate()




enum Tree:
  case Inner(left: Tree, right: Tree)
  case Leaf(x: Int)

def trees: Generator[Tree] =
  for
    isLeaf <- booleans
    tree <- if isLeaf then leaf else inners
  yield
    tree

def leafs =
  for x <- integers yield Tree.Leaf(x)

def inners =
  for x <- trees; y <- trees yield Tree.Inner(x, y)

trees.generate()


def test[T](g: Generator[T], numTimes: Int = 100)(test: T => Boolean): Unit =
  for i <- 0 until numTimes do
    val value = g.generate()
    assert(test(value), s"test failed for $value")
  println(s"passed $numTimes tests")


test(pairs(lists, lists)){
  (xs, ys) => (xs ++ ys).length >= xs.length
}