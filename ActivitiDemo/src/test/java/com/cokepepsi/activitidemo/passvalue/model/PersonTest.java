package com.cokepepsi.activitidemo.passvalue.model;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CokePepsi
 * @date 2023/12/15 18:43
 */
public class PersonTest {

    static Logger logger = LoggerFactory.getLogger(PersonTest.class);

    @Test
    public void testPassValue() {
        Person person = new Person();
        person.setAge(18);
        logger.info("传值前 ===> {}", person);

        testPassValue1(person);
        logger.info("testPassValue1 传值后 ===> {}", person);

        testPassValue2(person);
        logger.info("testPassValue2 传值后 ===> {}", person);
    }

    public void testPassValue1(Person person2) {
        person2.setAge(19);
    }


    public void testPassValue2(Person person){
       person = new Person();
       person.setAge(20);
    }
}
