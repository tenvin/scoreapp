package com.twg.entity;

import javax.persistence.*;

/**
 * Created by tenvin on 2017/7/26.
 */
@Entity
public class Score {
    @Id
    @GeneratedValue
    private int scoreId;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "bjId")
    private Banji banji;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "xsId")
    private Student student;//学生

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "zyId")
    private Zhuanye zhuanye;//专业

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "kmId")
    private Kemu kemu;//科目

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "xqId")
    private Xueqi xueqi;//学期

    private float fenshu;//分数

    public Score() {
    }

    public long getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
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

    public Banji getBanji() {
        return banji;
    }

    public void setBanji(Banji banji) {
        this.banji = banji;
    }

    public Score(Xueqi xueqi,Zhuanye zhuanye, Banji banji, Student student,  Kemu kemu,  float fenshu) {
        this.banji = banji;
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
                ", banji=" + banji +
                ", student=" + student +
                ", zhuanye=" + zhuanye +
                ", kemu=" + kemu +
                ", xueqi=" + xueqi +
                ", fenshu=" + fenshu +
                '}';
    }
}
