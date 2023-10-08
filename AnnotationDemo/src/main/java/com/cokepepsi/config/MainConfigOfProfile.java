package com.cokepepsi.config;

/**
 * @author CokePepsi
 * @date 2023/10/7 19:39
 */

import com.cokepepsi.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 *      Spring为我们提供的可以根据当前环境,动态的激活和切换一系列组件的功能
 *
 * 开发环境   -----   测试环境   ----- 生产环境
 * 数据源A    -----   数据源B   -----  数据源C
 *
 * @Profile 指定组件在哪个环境的情况下才能被注册到容器中,不指定,任何环境都能注册这个组件
 *
 * 1).加了环境标识的bean, 只有这个环境被激活的时候才能注册到容器中. 默认是default环境
 * 2).写在配置类上,只有是指定的环境的时候,真个配置类里面的所有配置才能开始生效.
 * 比如,我激活的环境是dev,如test02那个方法,,,,,,,MainConfigOfProfile的@Profile注解是test, 也就是整个配置类都不生效
 * 3).没有标注环境标识的bean在,任何环境下都是加载的
 *
 */
//@Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {



    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    private String driverClass;


    @Profile("test")
    @Bean
    public Yellow yellow() {
        return new Yellow();
    }

    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        driverClass = resolver.resolveStringValue("${db.driverClass}");
    }
}
