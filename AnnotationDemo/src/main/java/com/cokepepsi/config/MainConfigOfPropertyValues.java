package com.cokepepsi.config;

import com.cokepepsi.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author CokePepsi
 * @date 2023/9/26 19:30
 */
@Configuration
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中
//加载完外部的配置文件以后可以使用${}取出配置文件的值
@PropertySource(value = {"classpath:/person.properties"})
public class MainConfigOfPropertyValues {
    @Bean
    public Person person() {
        return new Person();
    }
}
