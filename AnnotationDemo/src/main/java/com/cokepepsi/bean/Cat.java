package com.cokepepsi.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author CokePepsi
 * @date 2023/9/25 20:15
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet...");
    }
}
