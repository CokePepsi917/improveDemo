package com.cokepepsi.springbootboy.controller;

import com.cokepepsi.springbootboy.bean.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CokePepsi
 * @date 2023/11/14 19:33
 */
@RestController
public class HelloController {

    @Resource
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String handle01() {
        return "Hello, Spring Boot 2!" + "你好";
    }
}
