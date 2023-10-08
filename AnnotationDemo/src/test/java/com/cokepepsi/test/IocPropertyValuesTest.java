package com.cokepepsi.test;

import com.cokepepsi.bean.Person;
import com.cokepepsi.config.MainConfigOfLifeCycle;
import com.cokepepsi.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:45
 */
public class IocPropertyValuesTest {
    //1.创建容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
    @Test
    public void test01() {
        System.out.println("=================");

        Person person  = (Person) applicationContext.getBean("person");
        String property = applicationContext.getEnvironment().getProperty("person.nickName");

        printBeans(applicationContext);
        System.out.println(person);
        System.out.println(property);
    }


    private void printBeans(ApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
