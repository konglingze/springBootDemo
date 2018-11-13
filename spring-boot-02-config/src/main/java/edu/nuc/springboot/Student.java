package edu.nuc.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

//@Component
//@ConfigurationProperties(prefix = "student")
//@PropertySource(value = {"classpath:student.properties"})
public class Student {
    private String id;
    private int age;
    private String name;
    private ArrayList<String> list;
    private HashMap<Integer, String> map;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public HashMap<Integer, String> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, String> map) {
        this.map = map;
    }

    public Student(String id, int age, String name, ArrayList<String> list, HashMap<Integer, String> map) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.list = list;
        this.map = map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
