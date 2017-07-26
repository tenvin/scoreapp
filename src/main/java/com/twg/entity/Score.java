package com.twg.entity;

import javax.persistence.*;

/**
 * Created by tenvin on 2017/7/26.
 */
@Entity
public class Score {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "sid")
    private Student student;//学生

//    private String nianji;//年级
//
//    private String banji;//班级

    //    private String xueqi;//学期
//    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id", insertable = false, updatable = false)
//    private Zhuanye zhuanye;//专业
//
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "kid")
    private Kemu kemu;//科目

    private String fenshu;//分数

    public Score() {
    }

    public Score(Student student, Zhuanye zhuanye, Kemu kemu, String fenshu) {
        this.student = student;

        this.fenshu = fenshu;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getFenshu() {
        return fenshu;
    }

    public void setFenshu(String fenshu) {
        this.fenshu = fenshu;
    }
}
