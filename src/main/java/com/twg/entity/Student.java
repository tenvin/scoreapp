package com.twg.entity;

import javax.persistence.*;

/**
 * Created by tenvin on 2017/7/24.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private long xsId;
    //姓名
    private String xsName;
//    //性别
//    private boolean xb;
//    //身份证
//    private String idcard;
//    //学号
//    private String xh;


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
}
