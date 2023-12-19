package com.cokepepsi.springbootboy.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author CokePepsi
 * @date 2023/11/14 19:27
 *
 * 只有在容器中的组件, 才会拥有SpringBoot提供的强大功能
 */
//@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;

    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
