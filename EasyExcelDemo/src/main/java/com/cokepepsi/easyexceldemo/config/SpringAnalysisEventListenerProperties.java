package com.cokepepsi.easyexceldemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CokePepsi
 * @date 2023/10/16 16:39
 */
@Component
@ConfigurationProperties(prefix = "com.cokepepsi.easyexceldemo")
public class SpringAnalysisEventListenerProperties {
    private List<Class<?>> listenerClasses = new ArrayList<>();

    public List<Class<?>> getListenerClasses() {
        return listenerClasses;
    }

    public void setListenerClasses(List<Class<?>> listenerClasses) {
        this.listenerClasses = listenerClasses;
    }
}
