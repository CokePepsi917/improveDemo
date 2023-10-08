package com.cokepepsi.test;

import com.cokepepsi.bean.Boss;
import com.cokepepsi.bean.Car;
import com.cokepepsi.bean.Color;
import com.cokepepsi.bean.Yellow;
import com.cokepepsi.config.MainConfigOfAutoWired;
import com.cokepepsi.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:45
 */
public class IocProfileTest {

    //1.切换环境: 使用命令行参数 在虚拟机参数位置加载 :-Dspring.profiles.active=test
    //使用命令行参数
    @Test
    public void test01() {

        //1.创建容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        Arrays.stream(beanNamesForType).forEach(System.out::println);
        applicationContext.close();
    }



    //使用代码的方式激活某种环境.
    @Test
    public void test02() {

        //1.创建容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");

        //3.注册主配置类
        applicationContext.register(MainConfigOfProfile.class);

        //4.启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        Arrays.stream(beanNamesForType).forEach(System.out::println);

        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);

        applicationContext.close();
    }
}
