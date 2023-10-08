package com.cokepepsi.test;

import com.cokepepsi.bean.User;
import com.cokepepsi.config.MainConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CokePepsi
 * @date 2023/10/7 15:03
 */
public class UserTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        User user = applicationContext.getBean(User.class);

        System.out.println("beanFactory:" + user.getBeanFactory());

        System.out.println("beanName:" + user.getBeanName());

        System.out.println("applicationContext:" + user.getApplicationContext());

        System.out.println("classLoader:" + user.getBeanClassLoader());
    }
}
