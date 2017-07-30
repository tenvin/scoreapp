package com.twg.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by tenvin on 2017/7/26.
 */
@Entity
public class Zhuanye {
    @Id
    @GeneratedValue
    private int zyId;

    private String zyName;//专业名

    public Zhuanye() {
    }

    public Zhuanye(String zyName) {
        this.zyName = zyName;
    }

    public String getZyName() {
        return zyName;
    }

    public void setZyName(String zyName) {
        this.zyName = zyName;
    }


    @Override
    public String toString() {
        return "Zhuanye{" +
                "zyId=" + zyId +
                ", zyName='" + zyName + '\'' +
                '}';
    }
}
