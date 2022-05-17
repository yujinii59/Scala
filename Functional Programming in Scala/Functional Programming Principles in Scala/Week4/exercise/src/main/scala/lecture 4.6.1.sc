// C[A] <: C[B] ==> C is covariant
// C[A] >: C[B] ==> C is contravariant
// neither C[A] nor C[B] is a subtype of the other ==> C is nonvariant

// class C[+A]{...} ==> C is covariant
// class C[-A]{...} ==> C is contravariant
// class C[A]{...} ==> C is nonvariant

trait Fruit
class Apple extends Fruit
class Orange extends Fruit

type FtoO = Fruit => Orange
type AtoF = Apple => Fruit
// FtoO <: AtoF

// if A2 <: A1 and B1 <: B2 then
// A1 => B1  <:  A2 => B2

//package scala
trait Function1[-T, +U]:
  def apply(x: T): U