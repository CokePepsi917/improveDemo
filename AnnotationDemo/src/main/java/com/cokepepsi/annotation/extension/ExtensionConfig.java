package com.cokepepsi.annotation.extension;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author CokePepsi
 * @date 2023/9/18 20:23
 */

/**
 * 扩展原理
 * BeanPostProcessor：bean后置处理器，bean创建对象初始化前后进行拦截工作
 * BeanFactoryPostProcessor：beanFactory的后置处理器；在BeanFactory标准化之后调用；所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 */
@ComponentScan("com.cokepepsi.annotation.extension")
@Configuration
public class ExtensionConfig {

}
