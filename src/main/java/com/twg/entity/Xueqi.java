package com.twg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tenvin on 2017/7/28.
 */
@Entity
public class Xueqi {
    @Id
    @GeneratedValue
    private int xqId;

    private String xqName;

    public Xueqi() {
    }

    public Xueqi(String xqName) {
        this.xqName = xqName;
    }

    public String getXqName() {
        return xqName;
    }

    public void setXqName(String xqName) {
        this.xqName = xqName;
    }

    @Override
    public String toString() {
        return "Xueqi{" +
                "xqId=" + xqId +
                ", xqName='" + xqName + '\'' +
                '}';
    }
}
