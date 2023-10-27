package com.cokepepsi.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author CokePepsi
 * @date 2023/10/17 8:34
 */
@Component
public class MyApplicationEventListener implements ApplicationListener<ApplicationEvent> {

    private static final Logger log = LoggerFactory.getLogger(Logger.class);

    // 当容器中发布此事件以后, 方法就会触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        Object source = event.getSource();
        log.info("source 是: {}", source);
        System.out.println("正在执行的事件是: " + event);
    }
}
