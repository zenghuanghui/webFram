package com.xxxx.mobile.service.impl;

import com.xxxx.mobile.bean.intelligentanswer.po.jpa.UserQuestion;
import com.xxxx.mobile.dao.jpa.UserQuestionDao;
import com.xxxx.mobile.service.UserQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserQuestionServiceImpl implements UserQuestionService {

    @Autowired
    private UserQuestionDao userQuestionDao;
    @Override
    public void saveUserQuestion(String opendId, String question) {
        UserQuestion userQuestion = new UserQuestion();
        userQuestion.setOpenId(opendId);
        userQuestion.setQuestion(question);
        userQuestion.setCreateTime(new Date());
        userQuestionDao.save(userQuestion);
    }
}
