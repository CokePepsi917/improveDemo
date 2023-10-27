package com.cokepepsi.annotation;

import org.springframework.core.Ordered;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author CokePepsi
 * @date 2023/10/12 13:38
 */
@CokePepsiTest("CokePepsi.class")
public class CokePepsi {

    @CokePepsiTest("test01")
    public void test01() {
        System.out.println("===========test01==========");
    }


    @CokePepsiTest("test02")
    public void test02() {
        System.out.println("===========test02==========");
    }


    @CokePepsiTest("test03")
    public void test03() {
        System.out.println("===========test03==========");
    }


    //@CokePepsiTest("test04")
    public void test04() {
        System.out.println("===========test04==========");
    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        CokePepsi cokePepsi = new CokePepsi();
        //1. 得到Class对象
        Class<CokePepsi> cokePepsiClass = CokePepsi.class;

        //2. 提取这个类中的全部成员方法
        Method[] declaredMethods = cokePepsiClass.getDeclaredMethods();

        //3. 遍历这个declaredMethods中的每个方法, 看方法上是否存在@MyTest注解, 存在
        //触发该方法的执行
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(CokePepsiTest.class)) {
                // 说明当前方法上面存在@CokepepsiTest, 触发当前方法执行.
                method.invoke(cokePepsi);
            }
        }
    }

}
