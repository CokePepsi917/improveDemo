package com.cokepepsi.springbootboy.bean;

/**
 * @author CokePepsi
 * @date 2023/11/7 19:05
 */
//宠物
public class Pet {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
