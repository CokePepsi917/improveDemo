package com.cokepepsi.config;

import com.cokepepsi.bean.Color;
import com.cokepepsi.bean.Person;
import com.cokepepsi.bean.Red;
import com.cokepepsi.condition.LinuxCondition;
import com.cokepepsi.condition.MyImportBeanDefinitionRegistrar;
import com.cokepepsi.condition.MyImportSelector;
import com.cokepepsi.condition.WindowsCondition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author CokePepsi
 * @date 2023/9/19 19:57
 */
//类中组件统一配置, 满足当前条件,这个类中配置的所有bean注册才能生效
@Conditional({WindowsCondition.class})
@Component
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import导入组件,id默认是组件的全类名
public class MainConfig2 {

    /**
     *
     * prototype 多实例, IOC容器启动时不会去调用方法创建对象放在容器中,每次获取的时候才会调用方法创建对象.
     * singleton 单实例(默认值), IOC容器启动会调用方法创建对象放到IOC容器中,以后每次获取就是直接从容器中拿.
     * request 同一次请求创建一个实例,
     * session 同一个session创建一个实例
     * @Scope注解 调整作用域
     * @return
     *
     *  懒加载:
     *      单实例bean: 默认在容器启动的时候创建对象
     *      懒加载: 容器启动时不创建对象. 第一次使用(获取)创建对象
     */
    @Lazy
//    @Scope(value = "prototype")
    @Scope
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person...");
        return new Person("张三", 25);
    }


    /**
     * @Conditional({Condition}): 按照一定的条件判断, 满足条件给容器中注册bean
     *  如果系统是 windows,给容器中注册("bill")
     *  如果系统是 Linux,给容器中注册("linus")
     */

    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48);
    }


    /**
     * 给容器中注册组件
     * 1).包扫描 + 组件标注注解(@Controller/@Service/@Repository/@Component)
     * 2).@Bean[导入的第三方包里的组件]
     * 3).@Import[快速给容器中导入一个组件]
     *      ①.@Import(要导入到容器的组件);容器中就会自动注册这个组件,id默认是全类名
     *      ②.ImportSelector:返回需要导入的组件的全类名
     *      ③.ImportBeanDefinitionRegistrar:手动注册到bean容器中
     */
}
