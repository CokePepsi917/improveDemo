package com.cokepepsi.config;

import com.cokepepsi.bean.Car;
import com.cokepepsi.bean.Color;
import com.cokepepsi.dao.BookDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/**
 * @author CokePepsi
 * @date 2023/9/26 20:43
 */


/**
 * 自动注入:
 *          Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系赋值
 *
 *  1) @Autowired :自动注入
 *          ① 默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookService.class) 找到就赋值
 *          ② 如果找到多个相同类型的组件, 再将属性的名称作为组件的id去容器中查找
 *                      applicationContext.getBean("bookDao)
 *           ③
 *  BookService {
 *       @Autowired
 *       BookDao bookDao;
 *  }
 *
 *  2) Spring支持使用@Resource(JSR250) 和 @Inject(JSR330)[java规范的注解]
 *              @Resource 可以和@Autowired一样实现自动装配功能, 默认按照组件名称进行装配的
 *              没有支持@Primary功能, 没有@Autowired的 Required = false 功能
 *
 *              @Inject
 *              需要导入javax.inject的包  和 Autowired一样  但没有required = false;
 *
 * 3) Autowired:构造器,参数,方法,属性: 都是从容器中好获取参数组件的值
 *      1)标注方法位置,,, @Bean + 方法参数; 参数从容器中获取; 默认不写@Autowired
 *      2)标注在构造器上,,,如果只有一个有参构造器,这个有参构造器的@Autowired可以省略.参数位置的组件可以自动从容器中获取.
 *      3)放在参数位置
 *
 * 4) 自定义组件想要使用Spring容器底层的一些组件(ApplicationContext, BeanFactory, xxx)等
 *         自定义组件实现xxxAware:在创建对象的时候,会调用接口规定的方法注入相关组件;
 *         xxxAware:功能使用xxxProcessor
 *         ApplicationContextAware ==> ApplicationContextAwareProcessor;
 *         在Processor中的Initialization方法那块,会判断bean属于哪个Aware接口,然后设置对饮的值.
 *
 * AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能
 *
 */
@Configuration
@ComponentScan({"com.cokepepsi.service", "com.cokepepsi.dao", "com.cokepepsi.controller","com.cokepepsi.bean"})
public class MainConfigOfAutoWired {

//    @Bean("bookDao2")
//    @Qualifier
//    public BookDao bookDao() {
//        BookDao bookDao = new BookDao();
//        bookDao.setLabel("2");
//        return bookDao;
//    }

    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
