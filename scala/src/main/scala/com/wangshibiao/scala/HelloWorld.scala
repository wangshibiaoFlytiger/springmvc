package com.wangshibiao.scala

import java.util.{Map => JavaMap}
import scala.collection.{mutable, JavaConverters}
import com.wangshibiao.scala.Model1

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
  def fun1(in: String): Map[String, String] ={
    var outMap:Map[String,String] = Map()
    outMap += ("in" -> in)
    outMap += ("msg" -> "我是自定义scala类的方法")
    return outMap;
  }

  def main(args: Array[String]) {
    var var1: String = "我调用的是scala方法"
    var var2: String = "我调用的是java jar的方法"
    println(var1)
    System.out.println(var2)
    //mapJava变量的类型:java.util.Map
    var mapJava:JavaMap[_, _] = Model1.fun1("scala类传给自定义java类的信息");
    println("mapJava.msg："+mapJava.get("msg"))
    //TODO: 如下代码运行时异常
    //将java中的Map转为scala中的Map
    /*var mapScala:mutable.Map[Any, Any] = JavaConverters.mapAsScalaMap(Model1.fun1("scala类传给自定义java类的信息")) ;
    println("mapScala.msg："+mapScala.get("msg"))*/
  }
}
