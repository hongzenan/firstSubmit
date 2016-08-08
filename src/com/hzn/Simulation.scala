package com.hzn

/**
  * Created by kanhong on 2016/7/21.
  */
abstract class Simulation {
  type Action = () => Unit

  case class WorkTime(time: Int, action: Action)

  private var curtime = 0

  def currentTime: Int = curtime

  private var agenda: List[WorkTime] = List()

  private def insert(ag: List[WorkTime], item: WorkTime): List[WorkTime] = {
    if (ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(ag.tail, item)
  }

  def afterDelay(delay: Int)(block: => Unit): Unit = {
    val item = WorkTime(currentTime + delay, () => Unit)
    agenda = insert(agenda, item)
  }

  private def next(): Unit = {
    (agenda: @unchecked) match {
      case item :: rest =>
        agenda = rest
        curtime = item.time
        item.action()
    }
  }

  def run(): Unit = {
    afterDelay(0) {
      println("*** simulation started,time = " + curtime + " ***")
    }
    while (!agenda.isEmpty) next()
  }

}
