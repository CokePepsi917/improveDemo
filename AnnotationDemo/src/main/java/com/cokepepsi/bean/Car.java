package com.cokepepsi.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:40
 */
@Component
public class Car {
    public Car() {
        System.out.println("构造方法 car constructor...");
    }

    public void init() {
        System.out.println("初始化方法 car init...");
    }

    public void destroy() {
        System.out.println("销毁方法 car destroy...");
    }
}
