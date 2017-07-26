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
    private long kid;

    private String name;

    public Kemu(String name) {
        this.name = name;
    }

    public Kemu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
