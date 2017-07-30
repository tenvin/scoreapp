package com.twg.entity;

import javax.persistence.*;

/**
 * Created by tenvin on 2017/7/26.
 */
@Entity
public class Score {
    @Id
    @GeneratedValue
    private long scoreId;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "xsId")
    private Student student;//学生

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "zyId", insertable = false, updatable = false)
    private Zhuanye zhuanye;//专业

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "kmId")
    private Kemu kemu;//科目

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "xqId")
    private Xueqi xueqi;//学期

    private float fenshu;//分数

    public Score() {
    }

    public long getScoreId() {
        return scoreId;
    }

    public void setScoreId(long scoreId) {
        this.scoreId = scoreId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Zhuanye getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(Zhuanye zhuanye) {
        this.zhuanye = zhuanye;
    }

    public Kemu getKemu() {
        return kemu;
    }

    public void setKemu(Kemu kemu) {
        this.kemu = kemu;
    }

    public Xueqi getXueqi() {
        return xueqi;
    }

    public void setXueqi(Xueqi xueqi) {
        this.xueqi = xueqi;
    }

    public float getFenshu() {
        return fenshu;
    }

    public void setFenshu(float fenshu) {
        this.fenshu = fenshu;
    }

    public Score(Student student, Zhuanye zhuanye, Kemu kemu, Xueqi xueqi, float fenshu) {

        this.student = student;
        this.zhuanye = zhuanye;
        this.kemu = kemu;
        this.xueqi = xueqi;
        this.fenshu = fenshu;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", student=" + student +
                ", zhuanye=" + zhuanye +
                ", kemu=" + kemu +
                ", xueqi=" + xueqi +
                ", fenshu=" + fenshu +
                '}';
    }
}
