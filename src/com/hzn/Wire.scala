import com.hzn.Simulation

/**
  * Created by kanhong on 2016/7/21.
  */
class Wire {
  type Action = () => Unit
  private var sigVal = false
  private var actions: List[Action] = List()

  def getSignal = sigVal

  def setSignal(s: Boolean) =
    if (s != sigVal) {
      sigVal = s
      actions foreach (_ ())
    }

  def addAction(a: Action) = {
    actions = a :: actions
    a()
  }
}
