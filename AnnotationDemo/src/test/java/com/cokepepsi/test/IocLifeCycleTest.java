package com.cokepepsi.test;

import com.cokepepsi.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:45
 */
public class IocLifeCycleTest {

    @Test
    public void test01() {
        //1.创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成....");
        applicationContext.getBean("car");

        applicationContext.getBean("cat");
        //关闭容器
        applicationContext.close();
    }
}
