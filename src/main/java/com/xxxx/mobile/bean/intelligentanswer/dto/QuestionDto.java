package com.xxxx.mobile.bean.intelligentanswer.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:06
 */
public class QuestionDto {

    @NotEmpty
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
