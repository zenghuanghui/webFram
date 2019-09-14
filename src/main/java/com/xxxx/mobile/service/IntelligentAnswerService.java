package com.xxxx.mobile.service;

import com.xxxx.common.bean.ResponseInfo;
import com.xxxx.mobile.bean.intelligentanswer.dto.QuestionDto;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:05
 */
public interface IntelligentAnswerService {

    ResponseInfo question(QuestionDto dto);

}
