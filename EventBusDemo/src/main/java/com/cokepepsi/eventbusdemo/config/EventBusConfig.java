package com.cokepepsi.eventbusdemo.config;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CokePepsi
 * @date 2023/9/20 16:13
 */
@Configuration
public class EventBusConfig {
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
