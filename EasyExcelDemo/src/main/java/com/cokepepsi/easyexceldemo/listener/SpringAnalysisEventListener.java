package com.cokepepsi.easyexceldemo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author CokePepsi
 * @date 2023/10/16 16:17
 */
public abstract class SpringAnalysisEventListener<T>  extends AnalysisEventListener<T> implements ApplicationContextAware {
    private ApplicationContext applicationContext;


    @Override
    public void invoke(T data, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //提供方法获取 Spring bean
    protected <S> S getBean(Class<S> clazz) {
        return applicationContext.getBean(clazz);
    }
}
