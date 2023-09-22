package com.cokepepsi.config;

/**
 * @author CokePepsi
 * @date 2023/9/18 20:51
 */

import com.cokepepsi.bean.Person;
import com.cokepepsi.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * 配置类 == 配置文件
 */
@Configuration //告诉Spring 这是一个配置类
//@ComponentScan(value = "com.cokepepsi")

@ComponentScans(value = {
        @ComponentScan(value = "com.cokepepsi", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[]: 指定要排除的包
//includeFilters = Filter[]: 指定扫描的时候只需要
//FilterType.Annotation; 按照注解的方式---常用
//FilterType.ASSIGNABLE_TYPE; 按照指定类型---常用
//FilterType.ASPECTJ; 使用AspectJ表达式
//FilterType.REGEX; 使用正则表达式
//FilterType.CUSTOM;自定义规则 ★
public class MainConfig {

    //给容器中注册一个Bean;类型为返回值的类型, id默认是用方法名作为id
    @Bean(value = "person") //指定Bean在容器中的名字
    public Person person01() {
        return new Person("lisi", 20);
    }
}
