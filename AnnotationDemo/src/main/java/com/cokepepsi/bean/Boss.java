package com.cokepepsi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author CokePepsi
 * @date 2023/10/7 18:47
 */
//默认加载ioc容器中的组件,容器启动时会调用午餐构造器创建对象,在进行初始化赋值
@Component
public class Boss {

    private Car car;

    //构造器要用的组件,也是从容器中获取

    public Boss(@Autowired Car car){
        this.car = car;
        System.out.println("boss 的 有参构造器");
    }
    public Car getCar() {
        return car;
    }

//    @Autowired
    //标注在方法,Spring容器创建当前对象,就会调用方法,完成赋值
    //方法使用的参数,自定义类型的值从ioc容器中获取.
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
