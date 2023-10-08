package com.cokepepsi.bean;

/**
 * @author CokePepsi
 * @date 2023/9/21 19:48
 */
public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
