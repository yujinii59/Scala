// Monard : just monoids in the category of endofunctors

extension [T, U](m: M[T])
  def flatMap(f: T => M[U]): M[U]

def unit[T](x: T): M[T]

m.map(f) == m.flatMap(x => unit(f(x)))
         == m.flatMap(f andThen unit)

extension [A, B, C](f: A => B)
  infix def andThen(g: B => C): A => C =
    x => g(f(x))


m.flatMap(f).flatMap(g) == m.flatMap(f(_).flatMap(g))
unit(x).flatMap(f)     == m.flatMap(f(_).flatMap(g))
f(x)                  == m.flatMap(f(_).flatMap(g))
f(x)                  == m.flatMap(unit)
f(x)                  == m

extension [T](xo: Option[+T])
  def flatMap[U](f: T => Option[U]): Option[U] = xo match
    case Some(x) => f(x)
    case None => None

