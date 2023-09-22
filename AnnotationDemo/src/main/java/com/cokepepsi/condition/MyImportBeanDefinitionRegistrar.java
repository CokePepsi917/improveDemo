package com.cokepepsi.condition;

import com.cokepepsi.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author CokePepsi
 * @date 2023/9/21 20:58
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata 当前类的注解信息
     * BeanDefinitionRegistry BeanDefinition注册类:
     *          把所需要添加到容器中的bean;调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean red = registry.containsBeanDefinition("com.cokepepsi.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.cokepepsi.bean.Blue");
        if (red && blue) {
            //指定Bean定义信息, (Bean的类型,Bean...)
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
            //注册一个Bean, 指定bean名
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
