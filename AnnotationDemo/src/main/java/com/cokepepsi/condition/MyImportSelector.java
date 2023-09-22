package com.cokepepsi.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Collections;
import java.util.Set;

/**
 * @author CokePepsi
 * @date 2023/9/21 20:29
 */
//自定义逻辑,返回需要的组件
public class MyImportSelector implements ImportSelector {

    //返回值,就是导入到容器中的组件的全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {"com.cokepepsi.bean.Blue", "com.cokepepsi.bean.Yellow"};
    }
}
