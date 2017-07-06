package com.wangshibiao.imoocannotation;

/**
 * Created by SamMFFL on 2016/4/22.
 */
@Description("I am interface")
public class Person {

    @Description("I am interface method")
    public String name(){
        return null;
    };

    public int age(){
        return 0;
    };

    @Deprecated
    public void sing(){};
}
