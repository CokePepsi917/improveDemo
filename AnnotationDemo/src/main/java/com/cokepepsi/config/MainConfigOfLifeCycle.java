package com.cokepepsi.config;

import com.cokepepsi.bean.Car;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:16
 *
 * bean的生命周期:
 *         bean的创建---初始化---销毁的过程
 * 容器管理bean的生命周期:
 *              我们可以自定义初始化和销毁方法: 容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 *    构造(对象创建)
 *    单实例:容器启动时就创建对象
 *    多实例:在每次获取的时候创建对象
 * * BeanPostProcessor.postProcessBeforeInitialization
 *  * 初始化:
 *  *      对象创建完成,并赋值好,调用初始化方法
 *  * BeanPostProcessor.postProcessAfterInitialization
 *              初始化:对象创建完成,并赋值好,调用初始化方法...
 *              销毁: 单实例 -> 容器关闭的时候进行销毁
 *                    多实例 -> 容器不会管理这个bean, 容器不会调用销毁方法
 *
 *          遍历容器中所有的BeanPostProcessor;挨个执行beforeInitialization,
 *          一旦返回null,跳出for循环,不会执行后面的BeanPostProcessor.postProcessAfterInitialization方法
 *
 *
 *         BeanPostProcessor原理
 *         populateBean(beanName, mbd, instanceWrapper);给bean属性赋值
 *         initializeBean
 *         {
 *            applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *            invokeInitMethods(beanName, wrappedBean, mbd);执行初始化方法
 *            applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *          }
 *
 *
 *
 *
 * 销毁:
 *              1) 指定初始化和销毁方法
 *                  init-method 和 destroy-method
 *              2) 通过Bean实现InitializingBean(定义初始化逻辑)
 *                             DisposableBean(定义销毁逻辑)
 *
 *              3) 使用JSR250:
 *                      @PostConstruct: 在bean窗前完成并且属性赋值完成 来执行初始化
 *                      @PreDestroy: 在容器销毁bean之前通知我们进行清除操作
 *
 *              4) BeanPostProcessor: bean的后置处理器;
 *                          在bean初始化前后进行一些处理工作:
 *                          postProcessBeforeInitialization: 在初始化之前工作
 *                          postProcessAfterInitialization: 在初始化之后工作
 *
 *
 */
@ComponentScan("com.cokepepsi.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
