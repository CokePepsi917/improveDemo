package com.cokepepsi.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author CokePepsi
 * @date 2023/9/19 21:08
 */
//判断是否是Linux系统
public class LinuxCondition implements Condition {
    /**
     * ConditionContext: 判断条件能使用的上下文(环境)
     * AnnotatedTypeMetadata: 注释信息
     * @param context the condition context
     * @param metadata the metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
     * or {@link org.springframework.core.type.MethodMetadata method} being checked
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //TODO 是否Linux系统
        //1.获取ioc使用beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.获取当前环境信息
        Environment environment = context.getEnvironment();
        //4.获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");

        if (property.contains("Linux")) {
            return true;
        }
        return false;
    }
}
