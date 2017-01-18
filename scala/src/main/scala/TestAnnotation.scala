/**
  * Created by Wang Shibiao on 2017/1/18.
  */
class A
class B extends A{
  //下面的注解用于标识getName方法在未来会被丢弃不推荐使用
  @deprecated
  def getName()="Class B"
}

object AnnotationDemo{
  def main(args: Array[String]): Unit = {
    var b=new B()
    //在调用的时候，编译器出给出相应提示
    b.getName()
  }
}