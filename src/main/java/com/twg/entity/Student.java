package com.twg.entity;

import javax.persistence.*;

/**
 * Created by tenvin on 2017/7/24.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private long sid;
    //姓名
    private String name;
//    //性别
//    private boolean xb;
//    //身份证
//    private String idcard;
//    //学号
//    private String xh;


    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
