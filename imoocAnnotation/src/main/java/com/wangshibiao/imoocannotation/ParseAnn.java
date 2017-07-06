package com.wangshibiao.imoocannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by SamMFFL on 2016/4/24.
 */
public class ParseAnn {
    public static void main(String[] args) {

        try {
            //1. 使用类加载器加载类
            Class c = Class.forName("com.wangshibiao.imoocannotation.Child");
            //2.找到类上面的注解
            boolean isExist = c.isAnnotationPresent(Description.class);
            if (isExist) {
                //3.拿到注解实例
                Description description = (Description) c.getAnnotation(Description.class);
                System.out.println(description.value());
            }
            //4.找到方法上的注解
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if (isMExist) {
                    Description d = (Description) m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }

            }

            for (Method m : ms) {
                Annotation[] as = m.getAnnotations();
                for (Annotation a : as) {
                    if (a instanceof Description) {
                        Description d = (Description) a;
                        System.out.println(d.value());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
