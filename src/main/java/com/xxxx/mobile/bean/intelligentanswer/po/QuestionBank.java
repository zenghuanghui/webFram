package com.xxxx.mobile.bean.intelligentanswer.po;

import javax.persistence.*;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:12
 */
@Entity
@Table(name="t_question_bank")
public class QuestionBank {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length = 255)
    private String question;

    @Column(length = 1000)
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
