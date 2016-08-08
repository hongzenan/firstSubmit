package com.hzn

/**
  * Created by kanhong on 2016/7/22.
  */
object Test {
  def signum(num: Int): Int = {
    if (num > 0) 1
    else if (num < 0) -1
    else 0
  }

  def countdown(n: Int) = {
    for (i <- 0 to n reverse)
      print(i + "\t")
  }

  def product(str: String): Long = {
    var t: Long = 1
    str.foreach(t *= _)
    t
  }

  def product1(str: String): Long = {
    if (str.length == 1)
      str.charAt(0).toLong
    else
      str.charAt(0) * product(str.drop(1))
  }

  def xn(x: Double, n: Int): Double = {
    if (n == 0) 1
    else if (n < 0) 1 / xn(x, -n)
    else if (n % 2 == 0) xn(x, n / 2) * xn(x, n / 2)
    else x * xn(x, n - 1)
  }

  def main(args: Array[String]): Unit = {
    var t: Int = 1
    var a = List(1, 3, 5, 7)
    a.foreach(t *= _)
    println(t)
    println(product1("Hello"))
    println(xn(0, 2))
  }
}

