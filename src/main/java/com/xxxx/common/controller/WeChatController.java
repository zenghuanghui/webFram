package com.xxxx.common.controller;


import com.alibaba.fastjson.JSON;
import com.xxxx.common.bean.output.TextMessage;
import com.xxxx.common.util.MessageReplyUtil;
import com.xxxx.common.util.MessageRevieveUtil;
import com.xxxx.common.util.WeChatUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/weChat")
public class WeChatController {

    @GetMapping()
    public void validToken(HttpServletRequest request, HttpServletResponse response){
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;

        System.out.println("signature: " + signature + "; timestamp: " + timestamp  + "; nonce: " + nonce + "; echostr: " + echostr);
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (WeChatUtil.checkSignature(signature, timestamp, nonce)) {
                System.out.println("valid success");
                out.print(echostr);
            }
            System.out.println("valid fail");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;
        }
    }

    @PostMapping()
    public void getMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> requestMap = MessageRevieveUtil.parseXml(request, response);
        System.out.println(JSON.toJSONString(requestMap));
        String event = requestMap.get("Event");
        String fromUserName = requestMap.get("FromUserName");
        String toUserName = requestMap.get("ToUserName");
        String key = requestMap.get("EventKey");
        String msgType = requestMap.get("MsgType");
        String message = requestMap.get("Content");

        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());


        //判断发送的类型是文本
        if(MessageRevieveUtil.TEXT_MESSAGE.equals(msgType)){
            textMessage.setContent("您发送的是文本消息: " + message);
        }else{
            textMessage.setContent("不能识别的消息~~ ");
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        System.out.println(JSON.toJSONString(textMessage));
        String sendTextMessage = MessageReplyUtil.sendTextMessage(textMessage);
        response.getWriter().write(sendTextMessage);
    }
}
