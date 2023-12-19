package com.cokepepsi.springbootboy.config;

import ch.qos.logback.core.db.DBHelper;
import com.cokepepsi.springbootboy.bean.Car;
import com.cokepepsi.springbootboy.bean.Pet;
import com.cokepepsi.springbootboy.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author CokePepsi
 * @date 2023/11/7 19:09
 * MyConfig效果等同于在resources文件夹下面创建一个beans.xml配置文件
 */

/**
 * 1. 配置里面使用@Bean标注在方法上给容器注册组件,  默认是单实例.....
 * 2. 配置类MyConfig也是组件
 * 3. proxyBeanMethods: 代理bean的方法
 *      Full (proxyBeanMethods = true),
 *      Lite(proxyBeanMethods = false)
 *     解决 组件依赖
 *     最佳实战:配置类组件之间无依赖关系用Lite模式 加速容器启动过程,  减少判断
 *              配置类之间有依赖关系, 方法回被调用得到之前单实例组件, 用Full模式.
 *
 *   4.@Import({User.class, DBHelper.class})
 *   给容器中自动创建这两个类型的组件 默认组件的名字就是全类名 com.cokepepsi.springbootboy.bean.User
 *   5. @ImportResource("classpath:beans.xml") 导入Spring的配置文件 beans.xml
 *
 */
@Import({User.class, DBHelper.class, Car.class})
@Configuration(proxyBeanMethods = true) //告诉Springboot这是一个配置类  == 配置文件
//@ConditionalOnBean(name = "tomcat")
@ConditionalOnMissingBean(name = "tomcat")
@ImportResource("classpath:beans.xml")
//@EnableConfigurationProperties({Car.class})
//1. 开启Car的属性配置绑定
//2.把Car这个组件自动注册到容器中....这样就不要把@Component加在 类上了    比如引入的第三方包  类上没有@Component注解---->用这种方法
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次  获取的 都是之前注册在容器中的单实例对象
     * @return
     */

    @Bean //给容器添加组件  方法名是组件id, 返回类型就是组件类型, 返回的值就是组件在容器中的实例
    public User user01() {
        User user = new User("张三", 19);
        user.setPet(tomcatPet());
        return user;
    }


    @Bean("tom2")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
