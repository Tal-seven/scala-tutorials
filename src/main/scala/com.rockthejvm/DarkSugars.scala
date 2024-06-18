package  com.rockthejvm 

object DarkSugars extends App {
  //syntax sugar # 1 - methods with single program
  def singleArgMethod(arg: Int) : String = s"$arg with string"

  val desc = singleArgMethod {
    // some other code here
    42
  }
  
  println(desc);
  
  trait Action {
    def act(x: Int): Int
  }

  val aFunkyInstance: Action = (x: Int) => x + 1

}
