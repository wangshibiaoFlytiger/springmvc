package com.wangshibiao.imoocannotation;

import java.lang.annotation.*;

/**
 * Created by SamMFFL on 2016/4/24.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String value();
}
