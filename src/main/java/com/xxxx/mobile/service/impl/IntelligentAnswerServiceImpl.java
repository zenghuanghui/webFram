package com.xxxx.mobile.service.impl;

import com.xxxx.common.bean.ResponseInfo;
import com.xxxx.mobile.bean.intelligentanswer.dto.QuestionDto;
import com.xxxx.mobile.bean.intelligentanswer.po.UserQuestion;
import com.xxxx.mobile.dao.QuestionBankDao;
import com.xxxx.mobile.dao.UserQuestionDao;
import com.xxxx.mobile.service.IntelligentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:05
 */
@Service
public class IntelligentAnswerServiceImpl implements IntelligentAnswerService {

    @Autowired
    private UserQuestionDao userQuestionDao;

    @Autowired
    private QuestionBankDao questionBankDao;

    @Override
    public ResponseInfo question(QuestionDto dto) {
        userQuestionDao.save(new UserQuestion(dto.getQuestion()));
        String answer = questionBankDao.findAnswer(dto.getQuestion());

        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setData(answer);
        return responseInfo;
    }
}
