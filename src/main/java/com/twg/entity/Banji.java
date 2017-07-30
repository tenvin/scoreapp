package com.twg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tenvin on 2017/7/30.
 */
@Entity
public class Banji {
    @Id
    @GeneratedValue
    private int bjId;

    private String bjName;

    public String getBjName() {
        return bjName;
    }

    public void setBjName(String bjName) {
        this.bjName = bjName;
    }

    public Banji(String bjName) {

        this.bjName = bjName;
    }

    public Banji() {

    }

    @Override
    public String toString() {
        return "Banji{" +
                "bjId=" + bjId +
                ", bjName='" + bjName + '\'' +
                '}';
    }
}
