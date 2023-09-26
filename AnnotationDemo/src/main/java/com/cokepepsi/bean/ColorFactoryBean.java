package com.cokepepsi.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:01
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // 默认单例
    //true 表示bean是单实例,在容器中保持一份
    //false 多实例,每次获取就会创建一个bean
    @Override
    public boolean isSingleton() {
        return false;
    }
}
