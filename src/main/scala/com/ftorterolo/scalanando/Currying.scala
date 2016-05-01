package com.ftorterolo.scalanando

/**
  * Methods may define multiple parameter lists.
  * When a method is called with a fewer number of parameter lists, then this will yield a function taking the missing parameter lists as its arguments.
  *
  * Note: method modN is partially applied in the two filter calls; i.e. only its first argument is actually applied.
  * The term modN(2) yields a function of type Int => Boolean and is thus a possible candidate for the second argument of function filter.
  */
object Currying extends App {


  val list = List(1,2,3,4,5,6,7,8)

//  def modulo(n:Int,x:Int) : Boolean = x % n == 0
  def modN(n:Int)(x:Int) : Boolean = x % n == 0

  def filter(list:List[Int], mod: Int => Boolean) : List[Int] = {
    if (list.isEmpty) list
    else if(mod(list.head)) list.head :: filter(list.tail, mod)
    else filter(list.tail,mod)
  }

  println(modN(3)(3))
  println(modN(3)(4))
  println(filter(list,modN(2)))
  println(filter(list,modN(3)))
}
