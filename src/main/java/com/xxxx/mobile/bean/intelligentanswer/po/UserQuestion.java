package com.xxxx.mobile.bean.intelligentanswer.po;

import javax.persistence.*;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:12
 */
@Entity
@Table(name="t_user_question")
public class UserQuestion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length = 255)
    private String question;

    public int getId() {
        return id;
    }

    public UserQuestion() {
    }

    public UserQuestion(String question) {
        this.question = question;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
