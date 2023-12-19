package com.cokepepsi.designpattern;

import java.lang.annotation.*;

/**
 * @author CokePepsi
 * @date 2023/10/12 10:39
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CokePepsiTest {
    String value() default "cokepepsi";

    String[] advice() default {"coke", "pepsi"};
}
