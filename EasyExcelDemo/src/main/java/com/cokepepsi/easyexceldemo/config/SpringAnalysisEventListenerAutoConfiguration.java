package com.cokepepsi.easyexceldemo.config;

import com.cokepepsi.easyexceldemo.register.SpringAnalysisEventListenerRegister;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CokePepsi
 * @date 2023/10/16 16:34
 */
@Configuration
public class SpringAnalysisEventListenerAutoConfiguration {
    private final ApplicationContext applicationContext;
    private final SpringAnalysisEventListenerProperties properties;

    public SpringAnalysisEventListenerAutoConfiguration(ApplicationContext applicationContext, SpringAnalysisEventListenerProperties properties){
        this.applicationContext = applicationContext;
        this.properties = properties;
    }


    @Bean
    public SpringAnalysisEventListenerRegister abstractSpringAnalysisEventListenerRegister() {
        return new SpringAnalysisEventListenerRegister(applicationContext, properties);
    }
}
