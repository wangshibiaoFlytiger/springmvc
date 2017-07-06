package com.wangshibiao.imoocannotation;

/**
 * Created by SamMFFL on 2016/4/22.
 */
public class AnnTest {

    @SuppressWarnings("deprecation")
    public void sing() {
        Person p = new Child();
        p.sing();
    }

    @Description("func")
    public String eyeColor() {
        return "red";
    }
}
