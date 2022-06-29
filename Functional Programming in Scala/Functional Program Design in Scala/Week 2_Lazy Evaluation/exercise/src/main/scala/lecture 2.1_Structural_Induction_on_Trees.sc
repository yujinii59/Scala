abstract class IntSet:
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet

object Empty extends IntSet:
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
  def union(other: IntSet) = other

case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet:

  def contains(x: Int): Boolean =
    if x < elem then left.contains(x)
    else if x > elem then right.contains(x)
    else true

  def incl(x: Int): IntSet =
    if x < elem then NonEmpty(elem, left.incl(x), right)
    else if x > elem then NonEmpty(elem, left, right.incl(x))
    else this

  def union(other: IntSet): IntSet =
    left.union(right.union(other)).incl(x)

/*
Empty.contains(x) = false
s.incl(x).contains(x) = true
s.incl(x).contains(y) = s.contains(y)  if x != y
*/

/* Proving the Laws of IntSet
1. Empty
Empty.contains(x) = false

2. s.incl(x).contains(x) = true
** Empty
Empty.incl(x).contains(x)
  = NonEmpty(x, Empty, Empty).contains(x)
  = true

** NonEmpty(x, l, r)
NonEmpty(x, l, r).incl(x).contains(x)
  = NonEmpty(x, l, r).contains(x)
  = true

** NonEmpty(y, l, r) where y < x
NonEmpty(y, l, r).incl(x).contains(x)
  = NonEmpty(y, l, r.incl(x)).contains(x)
  = r.incl(x).contains(x)
  = true

** NonEmpty(y, l, r) where y > x
NonEmpty(y, l, r).incl(x).contains(x)
  = NonEmpty(y, l.incl(x), r).contains(x)
  = l.incl(x).contains(x)
  = true

3. x != y => xs.incl(y).contains(x) = xs.contains(x)
** Empty
Empty.incl(y).contains(x)
  = NonEmpty(y, Empty, Empty).contains(x)
  = Empty.contains(x)

** NonEmpty(x, l, r) where z = x, z = y
NonEmpty(x, l, r).incl(y).contains(x)
  = NonEmpty(x, l.incl(y), r).contains(x)
  = true
  = NonEmpty(x, l, r).contains(x)

** NonEmpty(y, l, r) where z = x, z = y
NonEmpty(y, l, r).incl(y).contains(x)
  = NonEmpty(y, l, r).contains(x)

** NonEmpty(z, l, r) where z < y < x
NonEmpty(z, l, r).incl(y).contains(x)
  = NonEmpty(z, l, r.incl(y)).contains(x)
  = r.incl(y).contains(x)
  = r.contains(x)
  = NonEmpty(z, l, r).contains(x)

** NonEmpty(z, l, r) where y < z < x
NonEmpty(z, l, r).incl(y).contains(x)
  = NonEmpty(z, l.incl(y), r).contains(x)
  = r.contains(x)
  = NonEmpty(z, l, r).contains(x)

** NonEmpty(z, l, r) where y < x < z
NonEmpty(z, l, r).incl(y).contains(x)
  = NonEmpty(z, l.incl(y), r).contains(x)
  = l.incl(y).contains(x)
  = l.contains(x)
  = NonEmpty(z, l, r).contains(x)

4. xs.union(ys).contains(x) = xs.contains(x) || ys.contains(x)

*/