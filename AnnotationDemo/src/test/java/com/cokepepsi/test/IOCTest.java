package com.cokepepsi.test;

import com.cokepepsi.bean.Blue;
import com.cokepepsi.bean.Person;
import com.cokepepsi.config.MainConfig;
import com.cokepepsi.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;

/**
 * @author CokePepsi
 * @date 2023/9/18 21:21
 */
public class IOCTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }


    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        System.out.println("IOC容器创建完成....");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean == bean2);//默认是单实例的
    }


    @Test
    public void test03() {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        Environment environment = applicationContext.getEnvironment();
        //动态获取
        String property = environment.getProperty("os.name");
        System.out.println(property);
        Arrays.stream(beanNamesForType).forEach(System.out::println);

        Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);
    }


    @Test
    public void test04() {
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        //1.工厂Bean获取的是调用getObject创建的对象
        //2.想要拿到ColorFactoryBean对象本身 可以使用&colorFactoryBean
        Object bean1 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean1的类型" + bean1.getClass());
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean1 == bean2);

        System.out.println("bean3的类型是" + bean3.getClass());
    }


    private void printBeans(ApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
