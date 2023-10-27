package com.cokepepsi.ext;

import com.cokepepsi.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author CokePepsi
 * @date 2023/10/17 8:37
 */

/**
 * 扩展原理:
 * 1.BeanPostProcessor: bean后置处理器, bean创建对象初始化前后进行拦截工作的
 *  BeanFactoryPostProcessor:beanFactory的后置处理器:
 *         在beanFactory标准初始化之后调用: 所有的bean定义已经保存加载到beanFactory, 但是bean的实例还未创建.
 *
 *      1) ioc容器创建对象
 *      2) invokeBeanFactoryPostProcessors(beanFactory); 执行BeanFactoryPostProcessor
 *          如何找到所有的BeanFactoryPostProcessor并且执行他们的方法
 *          1] 直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件 并执行他们的方法
 *          2] 在初始化其他组件(其他bean)前面执行   ---------------------
 *          毕竟下面这个方法在
 *          // Invoke factory processors registered as beans in the context.
 * 				invokeBeanFactoryPostProcessors(beanFactory); 之后执行.
 *          // Instantiate all remaining (non-lazy-init) singletons.
 * 				finishBeanFactoryInitialization(beanFactory);
 *
 * 	2. BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 * 	                postProcessBeanDefinitionRegistry();
 * 	    在所有的beanDefinition信息,即bean定义信息将要被加载,bean的实例还未创建;--
 * 	        --在BeanFactoryPostProcessor这个接口的方法之前,,,,因为BeanFactoryPostProcessor已经有beanDefinition加载到beanFactory了
 *
 *
 *          BeanDefinitionRegistryPostProcessor优先与BeanFactoryPostProcessor执行,
 *          可利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件.
 *
 *  原理:
 *      第一步 创建ioc对象
 *      第二步 refresh() -> invokeBeanFactoryPostProcessors(beanFactory)
 *      第三步 从容器中获取到所有的 BeanDefinitionRegistryPostProcessor组件.
 *              1. 依次触发所有的postProcessBeanDefinitionRegistry()方法
 *              2. 再来触发postProcessBeanFactory()方法 BeanFactoryPostProcessor
 *      第四步 再来从容器中找到BeanFactoryPostProcessor  然后依次触发postProcessBeanFactory()方法
 *
 *
 *
 *
 *
 *
 * 3. ApplicationListener: 监听容器中发布的事件, 事件驱动模型开发.
 *      public interface ApplicationListener<E extends ApplicationEvent>
 *            监听ApplicationEvent及其子事件
 *
 *      步骤:
 *          1) 写一个监听器来监听某个事件(ApplicationEvent及其子类)

 *          2) 把监听器加入到容器
 *          3) 只要容器有相关的事件发布, 我们就能监听到这个事件.
 *              ContextRefreshedEvent:容器刷新完成(所有的bean都完全创建) 会发布这个事件.
 *              ContextClosedEvent: 关闭容器会发布这个事件.
 *          4) 发布一个事件:
 *                  applicationContext.publishEvent(event);
 *
 *
 *  原理:ContextRefreshedEvent、TestEvent$1[source=啊实打实]、ContextClosedEvent
 *           1) ContextRefreshedEvent事件
 *                  1):容器创建 调 refresh()方法         --->	refresh();
 *                  2):finishRefresh();容器刷新完成   ---> publish corresponding event.发布相关事件
 *           2) 自己发布的事件
 *           3) 容器关闭 会发布ContextClosedEvent
 *                  [事件发布流程]
 *                  3):publishEvent(new ContextRefreshedEvent(this));
 *                      1). 获取事件的多播器(派发器):getApplicationEventMulticaster()
 *                      2). multicastEvent 派发事件
 *                      3). 获取所有的ApplicationListener:
 *                              for (ApplicationListener<?> listener : getApplicationListeners(event, type))
 *                              1) 如果有Executor, 可以使用Executor进行异步派发
 *                                      Executor executor = getTaskExecutor();
 *                              2) 如果没有,则用同步的方式执行listener方法: invokeListener(listener, event)
 *                                  拿到listener回调onApplicationEvent方法;			listener.onApplicationEvent(event);
 *
 *     [事件多播器(派发器)]
 *          1) 容器创建对象 : refresh();
 *          2) initApplicationEventMulticaster(); 初始化ApplicationEventMulticaster;
 *                 1) 先去容器找有没有 id="applicationEventMulticaster"的组件, 有就直接获取
 *                          if (beanFactory.containsLocalBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME))
 *                 2 如果没有, 则创建一个
 *                          this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *                   并且加入到容器中, 我们就可以在其他组件要派发事件, 自动注入这个applicationEventMulticaster
 *                   beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, this.applicationEventMulticaster);
 *
 *     [怎么知道容器中有哪些监听器]
 *           1) 容器创建对象 : refresh();
 *           2) registerListeners(); //注册监听器
 *                  从容器中拿到所有的监听器, 把他们注册到applicationEventMulticaster中;
 *                  String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *                  // 将listener 注册到ApplicationEventMulticaster中.
 *                 for (String listenerBeanName : listenerBeanNames) {
 * 			            getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *                }
 *
 *
 *   第二种监听事件的方法:
 *    @EventListener 使用这个注解可以让任意一个业务逻辑组件去监听事件.
 *    原理:
 *          使用EventListenerMethodProcessor处理器来解析@EventListener注解   ----> EventListenerMethodProcessor 实现了SmartInitializingSingleton接口
 *
 *     SmartInitializingSingleton原理
 *      1) ioc容器创建对象并refresh()
 *      2) finishBeanFactoryInitialization(beanFactory);初始化剩下的单实例bean
 *          1) 先创建所有的bean: getBean();
 *          2) 获取所有创建好的bean: 判断是否是SmartInitializingSingleton类型的
 *              如果是就调用afterSingletonsInstantiated();
 */
@ComponentScan("com.cokepepsi.ext")
@Configuration
public class ExtConfig {
    @Bean
    public Blue blue() {
        return new Blue();
    }
}
