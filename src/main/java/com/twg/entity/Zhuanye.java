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
    private long zyId;

    private String zyName;//专业名

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "zyid")
    private Set<Kemu> kemus;

    public Zhuanye() {
    }

    public String getZyName() {
        return zyName;
    }

    public void setZyName(String zyName) {
        this.zyName = zyName;
    }

    public Set<Kemu> getKemus() {
        return kemus;
    }

    public void setKemus(Set<Kemu> kemus) {
        this.kemus = kemus;
    }
}
