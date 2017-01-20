package com.wangshibiao.spring.nexus;

import com.wangshibiao.scala.HelloWorld;
import com.wangshibiao.scala.Model1;
import scala.collection.JavaConverters;

import java.util.Map;

/**
 * Created by Wang Shibiao on 2017/1/19.
 */
public class NexusPrivateJar {
    public static void main(String[] args){
        Map mapFromJava = Model1.fun1("调用私有nexusPrivateJar中的java类");
        Map mapFromScala = JavaConverters.mapAsJavaMap(HelloWorld.fun1("调用私有nexusPrivateJar中的scala类"));
    }
}
