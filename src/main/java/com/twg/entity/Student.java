package com.twg.entity;

import javax.persistence.*;

/**
 * Created by tenvin on 2017/7/24.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private int xsId;

    private String xsName;

    public Student() {
    }

    public String getXsName() {
        return xsName;
    }

    public void setXsName(String xsName) {
        this.xsName = xsName;
    }

    public Student(String xsName) {

        this.xsName = xsName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "xsId=" + xsId +
                ", xsName='" + xsName + '\'' +
                '}';
    }
}
