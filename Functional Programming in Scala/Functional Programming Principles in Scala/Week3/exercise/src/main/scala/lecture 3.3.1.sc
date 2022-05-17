// Nil : the empty list
// Cons : a cell containing an element and the remainder of the list

List(1, 2, 3)
//                  Cons
//                  /  \
//                 1  Cons
//                    /  \
//                   2  Cons
//                      /  \
//                     3   Nil

List(List(true, false), List(3))
//                    Cons
//                  /       \
//               Cons       Cons
//               /  \       /  \
//            true  Cons   3   Nil
//                  /  \
//              false  Nil