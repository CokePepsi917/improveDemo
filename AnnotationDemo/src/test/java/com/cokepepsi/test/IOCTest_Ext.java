package com.cokepepsi.test;

import com.cokepepsi.aop.MathCalculator;
import com.cokepepsi.config.MainConfigOfAOP;
import com.cokepepsi.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:45
 */

public class IOCTest_Ext {

    @Test
    public void test01() {
        //1.创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        applicationContext.close();
    }
}
