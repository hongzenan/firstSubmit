package com.hzn.useOfVal.com.hzn.useOfVal

/**
  * Created by kanhong on 2016/8/3.
  */
object hello83 {
  /*  !*/
  def factorial(n:Int)=1 to n reduceLeft(_*_)
  class m1(n:Int){
    def ! = factorial(n)
  }
  implicit def m2(n:Int)=new m1(n)
  def main(args: Array[String]) {
    /*    filter, take and exists for find prime*/
    def prime(n: Int) = (!((2 to math.sqrt(n).toInt) exists (i => n % i == 0)))
    println(2 to 100 filter prime take 10 mkString (" "))

    /*    takeWhile,dropWhile,span and 10 to (1,-1)*/
    println(1 to 10 takeWhile (_ < 5))
    println(1 to 10 takeWhile (_ > 5))
    println(10 to(1, -1) takeWhile (_ > 5))
    println(1 to 10 dropWhile (_ > 5))
    println(1 to 10 dropWhile (_ < 5))
    println(1 to 10 span (_ < 5))
    println(1 to 10 span (_ > 5))
    println(List(1, 0, 1, 0) span (_ > 0))
    println(List(1, 0, 1, 0) partition (_ > 0))

    /*    triangle*/
    def triangle() = for {
      x <- 1 to 21
      y <- x to 21
      z <- y to 21
      if x*x+y*y==z*z
    }yield (x,y,z)
    println(triangle().mkString("\t"))

    val c1 = new complex(3,10)
    val c2 = new complex(5,70)
    printf("%s + %s = %s\n",c1, c2, c1+c2)

/*    implicit change*/
    implicit def foo(s:String):Int=Integer.parseInt(s)
    def add(a:Int, b:Int)=a + b
    println(add("100",8))

/*    !*/
    val n=4
    printf("%d! = %s\n", n, (n!))

/*    ***/
    def pow(n:Int, m:Int):Int=if(m==0) 1 else n*pow(n,m-1)
    implicit def foo1(n:Int)=new{
      def **(m:Int)=pow(n,m)
    }
    println(2**10)

/*    映射式函数定义*/
    def a(x:Int)={(y:Int)=>x+y}
    println(a(3)(4))

/*    Hanoi汉诺塔*/
    def move(n:Int, a:Int, b:Int, c:Int) :Unit={
      if(n==1) printf("%s to %s\n",a,c) else {
        move(n-1,a,c,b);move(1,a,b,c);move(n-1,b,a,c)
      }
    }
    move(2,1,2,3)
  }

/*  complex*/
  class complex(val i:Int, val j:Int){
    def +(c2:complex)={
      new complex(i+c2.i, j+c2.j)
    }
  override def toString()={"(" + i + "," + j + ")"}
  }


}
