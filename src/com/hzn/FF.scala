package com.hzn

/**
  * Created by kanhong on 2016/7/23.
  */
object FF {
  def main(args: Array[String]) {
    println("Hello World!")
    val a=new FF("love zz")
    println(a.abc)
  }

}

class FF (param:String){
  val abc: String = param
}
