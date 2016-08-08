package com.hzn.useOfVal

import javax.print.DocFlavor.BYTE_ARRAY


/**
  * Created by kanhong on 2016/7/25.
  */
object scala {
  def main(args: Array[String]): Unit = {
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money < 0 || coins.size == 0) 0
      else countChange(money, coins.tail) + countChange(money - coins.head, coins)
    }
    println(countChange(11, List(1, 2, 5)))

    def fact(n: Int): Int = {
      def loop(acc: Int, n: Int): Int =
        if (n == 0) acc else loop(acc * n, n - 1)

      loop(1, n)
    }
    println(fact(4))

    def quick(xs: List[Int]): List[Int] = {
      if (xs.isEmpty) xs
      else quick(xs.filter(x => x < xs.head)) ::: xs.head :: quick(xs.filter(x => x > xs.head))
    }
    println(quick(List(1, 4, 8, 2, 9, 3, 7, 5)).mkString(" "))

    def reverse(xs: String): String= if(xs.isEmpty) xs else reverse(xs.tail)+xs.head
    println(reverse(".zz evol i"))

  }

  println((1 to 9) map (a=> (1 to 9) map (b=> a+"*"+b+"="+a*b) mkString("\t")) mkString("\n"))

  val a=for(i<- 1 to 9) yield{
    for(j<- 1 to 9) yield{
      i+"*"+j+"="+i*j
    }
  }.mkString("\t")
  println(a.mkString("\n"))
}
