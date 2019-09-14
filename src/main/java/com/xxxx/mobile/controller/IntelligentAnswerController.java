package com.xxxx.mobile.controller;

import com.xxxx.common.bean.ResponseInfo;
import com.xxxx.common.constant.ResponseCode;
import com.xxxx.mobile.bean.intelligentanswer.dto.QuestionDto;
import com.xxxx.mobile.service.IntelligentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:03
 */
@RestController
@RequestMapping("/intelligentAnswer")
public class IntelligentAnswerController {

    @Autowired
    private IntelligentAnswerService intelligentAnswerService;

    @PostMapping("/question")
    public ResponseInfo question(@RequestBody @Valid QuestionDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseInfo(ResponseCode.CODE_PARAM_INVALID);
        }

        return intelligentAnswerService.question(dto);
    }
}
