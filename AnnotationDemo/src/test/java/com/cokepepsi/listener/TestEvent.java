package com.cokepepsi.listener;

import com.cokepepsi.ext.ExtConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CokePepsi
 * @date 2023/10/17 8:35
 */

public class TestEvent {

    @Test
    public void testMyApplicationEvent() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        // 发布事件
        applicationContext.publishEvent(new ApplicationEvent( ("啊实打实")){
        });
        applicationContext.close();
    }
}
