package com.cokepepsi.test;

import com.cokepepsi.aop.MathCalculator;
import com.cokepepsi.bean.Boss;
import com.cokepepsi.bean.Car;
import com.cokepepsi.bean.Color;
import com.cokepepsi.config.MainConfigOfAOP;
import com.cokepepsi.config.MainConfigOfAutoWired;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:45
 */

public class AOPTest {

    @Test
    public void test01() {
        //1.创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1.不要自己创建对象,拿容器中的对象
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);

        int div = bean.div(1, 1);
        System.out.println(div);
    }
}
