package com.cokepepsi.ext;

import com.cokepepsi.bean.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author CokePepsi
 * @date 2023/10/18 19:31
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry...bean的数量" + registry.getBeanDefinitionCount());
//        RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
        registry.registerBeanDefinition("Hello", beanDefinition);
    }

    // bean定义信息的保存中心---以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量" + beanFactory.getBeanDefinitionCount());
    }
}
