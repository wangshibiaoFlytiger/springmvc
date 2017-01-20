package com.wangshbiao.scala;

import java.util.HashMap;
import java.util.Map;

import com.wangshibiao.scala.HelloWorld;
import scala.collection.JavaConverters;

/**
 * Created by Wang Shibiao on 2017/1/17.
 */
public class Model1 {
    public static Map fun1(String in){
        Map<String, String> outMap = new HashMap<>();
        outMap.put("in", in);
        outMap.put("msg", "我是自定义java类的方法");

        return outMap;
    }

    public static void main(String[] args){
        String var1 = "我调用的是java方法";
        String var2  = "我调用的是scala jar的方法";
        System.out.println(var1);
        scala.Predef.println(var2);
        //mapScala变量的类型:scala.collection.immutable.Map<String, String>
        scala.collection.immutable.Map<String, String> mapScala =  HelloWorld.fun1("java类传给自定义scala类的信息");
        //将scala中的Map转为java中的Map
        Map<String, String> mapJava = JavaConverters.mapAsJavaMap(HelloWorld.fun1("java类传给自定义scala类的信息"));
        System.out.println((mapScala.get("msg")));
        System.out.println((mapJava.get("msg")));
    }
}
