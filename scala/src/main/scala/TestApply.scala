/**
  * Created by Wang Shibiao on 2017/1/18.
  */
object TestApply {
  def main(args: Array[String]) {

    val x = TestApply(5)
    println(x)

    x match
    {
      case TestApply(num) => println(x+" is bigger two times than "+num)
      case _ => println("i cannot calculate")
    }
  }

  def apply(x: Int) = {
    println("进入apply方法")
    x*2
  }

  def unapply(z: Int): Option[Int] = {
    println("进入unapply方法")
    if (z%2==0)
      Some(z/2)
    else
      None
  }
}
