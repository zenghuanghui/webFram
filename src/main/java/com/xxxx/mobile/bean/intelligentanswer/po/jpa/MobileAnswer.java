package com.xxxx.mobile.bean.intelligentanswer.po.jpa;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:12
 */
@Entity
@Table(name="t_mobile_answer")
public class MobileAnswer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length = 255)
    private String uuid;

    @Column
    private String question;

    @Column
    private String answer;

    @Column
    private String url;

    @Column
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
