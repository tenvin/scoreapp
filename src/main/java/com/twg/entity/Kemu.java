package com.twg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tenvin on 2017/7/26.
 */
@Entity
public class Kemu {
    @Id
    @GeneratedValue
    private int kmId;

    private String kmName;

    public Kemu(String name) {
        this.kmName = name;
    }

    public Kemu() {
    }

    public String getName() {
        return kmName;
    }

    public void setName(String name) {
        this.kmName = name;
    }

    @Override
    public String toString() {
        return "Kemu{" +
                "kmId=" + kmId +
                ", kmName='" + kmName + '\'' +
                '}';
    }
}
