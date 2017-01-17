/**
  * Created by Wang Shibiao on 2017/1/17.
  * 一.命令行编译、运行
  * 1. scalac -d F:\github\springmvc\out\build\scala\classes\main F:\github\springmvc\scala\src\main\scala\HelloWorld.scala
  * 2. scala -cp F:\github\springmvc\out\build\scala\classes\main HelloWorld
  * 二.gradle编译
  * gradle scala:compileScala
  * 三. 注意
  * 验证发现如下现象：
  * 代码必须经过手动编译后，才能断点调试
  */
object HelloWorld {
  def main(args: Array[String]) {
    var var1: String = "hello world"
    println(var1)
  }
}
