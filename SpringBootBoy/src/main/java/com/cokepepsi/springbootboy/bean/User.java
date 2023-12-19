package com.cokepepsi.springbootboy.bean;

/**
 * @author CokePepsi
 * @date 2023/11/7 19:05
 */


//用户
public class User {

    private String name;

    private Integer age;

    private Pet pet;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
