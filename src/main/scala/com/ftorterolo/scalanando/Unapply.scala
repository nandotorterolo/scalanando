package com.ftorterolo.scalanando


object Twice {
  def apply(x: Int): Int = x * 2
  def unapply(z: Int): Option[Int] = if (z%2 == 0) Some(z/2) else None
}

object Unapply extends App {
  val x:Int = Twice(21)

//  The pattern case Twice(n) will cause an invocation of Twice.unapply
  x match { case Twice(n) => Console.println(n) } // prints 21

}
