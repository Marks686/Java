package com.demo.model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-21
 * Time: 16:49
 */
public class Student {
    private int id;
    private String name;
    private int age;
    //...

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
