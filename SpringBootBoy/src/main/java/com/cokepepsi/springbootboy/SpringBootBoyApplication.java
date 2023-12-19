package com.cokepepsi.springbootboy;

import ch.qos.logback.core.db.DBHelper;
import com.cokepepsi.springbootboy.bean.Pet;
import com.cokepepsi.springbootboy.bean.User;
import com.cokepepsi.springbootboy.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 主程序类
 * @SpringBootApplication
 */
@SpringBootApplication  //相当于下面三个注解的综合
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.cokepepsi.springbootboy")
public class SpringBootBoyApplication {

    public static void main(String[] args) {
        //1. 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootBoyApplication.class, args);

        //2.查看容器中的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);

        //3. 从容器中获取组件,
//        Pet tom01 = run.getBean("tomcatPet", Pet.class);
//
//        Pet tom02 = run.getBean("tomcatPet", Pet.class);
//
//        System.out.println("组件:" + (tom01 == tom02) );
//
//        //4.com.cokepepsi.springbootboy.config.MyConfig$$EnhancerBySpringCGLIB$$fa179bfd@3e681bc(代理对象)
//        MyConfig myConfig = run.getBean(MyConfig.class);
//        System.out.println(myConfig);
//
//        //如果@Configuration(proxyBeanMethods = true),,代理对象调用方法, Springboot总会检查这个组件是否在容器中有
//        //保持组件的单实例
//        User user = myConfig.user01();
//        User user1 = myConfig.user01();
//
//        //如果@Configuration(proxyBeanMethods = false) 拿到的不是代理对象,就不能保证单实例
//        System.out.println(user == user1);
//
//
//        User user2 = myConfig.user01();
//        Pet pet = user2.getPet();
//        System.out.println("宠物是不是一样的" + (pet == myConfig.tomcatPet()));
//
//
//
//        //5.
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        Arrays.asList(beanNamesForType).forEach(System.out::println);
//
//        DBHelper bean = run.getBean(DBHelper.class);
//        System.out.println(bean);
        boolean tomcat = run.containsBean("tom2");
        System.out.println("tom2" + tomcat);

        boolean user01 = run.containsBean("user01");
        System.out.println("存在user01" + user01);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");

        System.out.println(haha);
        System.out.println(hehe);

    }

}
