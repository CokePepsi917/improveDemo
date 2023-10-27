package com.cokepepsi.bean;

/**
 * @author CokePepsi
 * @date 2023/9/21 20:37
 */
public class Blue {
    public Blue(){
        System.out.println("blue....constructor");
        System.out.println("blue的构造器执行...实例化");
    }

    public void init() {
        System.out.println("blue .... init...");
    }

    public void destroy() {
        System.out.println("blue....destroy...");
    }
}
