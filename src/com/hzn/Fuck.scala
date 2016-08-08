package com.hzn


/**
  * Created by kanhong on 2016/7/17.
  */
object Fuck {
  def main(args: Array[String]): Unit = {

    val a = (1 to 10).fold(0)(_ + _)
    var aa = 10
    aa = 11
    println(a)

  }
}

class Fuck(n: Int, d: Int) {

  for (i <- (1 to 10)) yield (i * 2)
  (1 to 10).map(_ * 2)

  val nn = n
  val dd = d

  override def toString = nn + "/" + dd

  def this(n: Int) = this(n, 1)

  def +(that: Fuck) = {
    new Fuck(nn * that.dd + dd * that.nn, dd * that.dd)
  }
}

