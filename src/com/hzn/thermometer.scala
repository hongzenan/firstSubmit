/**
  * Created by kanhong on 2016/7/20.
  */
class thermometer {
  var celsius: Float = _

  def fahrenheit = celsius * 9 / 5 + 32

  def fahrenheit_=(f: Float) {
    celsius = (f - 32) * 5 / 9
  }

  override def toString = fahrenheit + "F/" + celsius + "C"

}

object thermometer {
  def main(args: Array[String]) {
    val t = new thermometer
    println(t)
    t.celsius = 100
    println(t)
    t.fahrenheit = -40
    println(t)
  }

}
