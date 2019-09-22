package com.xxxx.mobile.bean.intelligentanswer.po.es;

import com.xxxx.mobile.bean.intelligentanswer.po.jpa.MobileAnswer;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/19 20:21
 */

@Document(indexName = "mobile",type = "answer", shards = 5,replicas = 0, refreshInterval = "-1")
public class EsMobileAnswer {

    @Id
    private String id;

    @Field
    private String question;

    @Field
    private String answer;

    @Field
    private String mobileModel;

    @Field
    private String originUrl;

    public EsMobileAnswer() {
    }

    public EsMobileAnswer(MobileAnswer e) {
        this.id = e.getUuid();
        this.question = e.getQuestion();
        this.answer = e.getAnswer();
        this.originUrl = e.getUrl();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }
}
