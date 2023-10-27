package com.cokepepsi.easyexceldemo.register;

import com.alibaba.excel.event.AnalysisEventListener;
import com.cokepepsi.easyexceldemo.config.SpringAnalysisEventListenerProperties;
import org.springframework.context.ApplicationContext;

/**
 * @author CokePepsi
 * @date 2023/10/16 16:44
 */
public class SpringAnalysisEventListenerRegister {
    private final ApplicationContext applicationContext;

    private final SpringAnalysisEventListenerProperties properties;

    public SpringAnalysisEventListenerRegister(ApplicationContext applicationContext, SpringAnalysisEventListenerProperties properties) {
        this.applicationContext = applicationContext;
        this.properties = properties;

        registerListeners();
    }

    private void registerListeners() {
        for (Class<?> listenerClass : properties.getListenerClasses()) {
            if (AnalysisEventListener.class.isAssignableFrom(listenerClass)) {
                applicationContext.getAutowireCapableBeanFactory().createBean(listenerClass);
            }
        }
    }
}
