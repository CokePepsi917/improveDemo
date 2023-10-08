package com.cokepepsi.test;

import com.cokepepsi.bean.Boss;
import com.cokepepsi.bean.Car;
import com.cokepepsi.bean.Color;
import com.cokepepsi.config.MainConfigOfAutoWired;
import com.cokepepsi.config.MainConfigOfLifeCycle;
import com.cokepepsi.dao.BookDao;
import com.cokepepsi.service.BookService;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author CokePepsi
 * @date 2023/9/25 19:45
 */
public class IocAutowiredTest {

    @Test
    public void test01() {
        //1.创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);
//        BookService bookService = applicationContext.getBean(BookService.class);
//        System.out.println(bookService);
//
//        BookDao bookDao = applicationContext.getBean(BookDao.class);
//        System.out.println(bookDao);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println( "boss 的 car 是" + boss.getCar());

        Car car = applicationContext.getBean(Car.class);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(applicationContext);
        System.out.println(color.getCar());
        System.out.println(car);
    }
}
