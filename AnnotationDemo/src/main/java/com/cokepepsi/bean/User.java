package com.cokepepsi.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author CokePepsi
 * @date 2023/10/7 14:57
 */
public class User implements ApplicationContextAware, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware {

    private int id;

    private String username;

    private String beanName;

    private ClassLoader beanClassLoader;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", beanName='" + beanName + '\'' +
                ", beanClassLoader=" + beanClassLoader +
                ", beanFactory=" + beanFactory +
                ", applicationContext=" + applicationContext +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBeanName() {
        return beanName;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println(" >>> setClassLoader");
        this.beanClassLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(" >>> setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(" >>> setBeanName");
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(" >>> setApplicationContext");
        this.applicationContext = applicationContext;
    }
}
