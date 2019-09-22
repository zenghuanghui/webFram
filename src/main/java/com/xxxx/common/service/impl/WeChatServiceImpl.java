package com.xxxx.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxxx.common.bean.WeChat.WeChatUserInfo;
import com.xxxx.common.service.WeChatService;
import com.xxxx.common.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeChatServiceImpl implements WeChatService
{
    // 获取access_token的接口地址（GET） 限2000（次/天）
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APP_ID&secret=APP_SECRET";
    private static final String APP_ID = "wx6acac99c8ebaea70";
    private static final String  APP_SECRET = "3b02536577c0e9335c422dbac9e03a55";

    public final static String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPEN_ID";

    private String accessToken = null;
    @Override
    @Scheduled(fixedRate = 1000 * 60 * 59 * 2)
    public void freshAccessToken() {
        String requestUrl = ACCESS_TOKEN_URL.replace("APP_ID", APP_ID).replace("APP_SECRET", APP_SECRET);
        String result = null;
        try {
            result = HttpUtil.get(requestUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (null != jsonObject) {
            accessToken = jsonObject.getString("access_token");
        }
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public WeChatUserInfo getWeChatUserInfo(String openId) {
        if (StringUtils.isEmpty(accessToken)) {
            freshAccessToken();
        }
        String result = null;
        String requestUrl = USER_INFO_URL.replace("ACCESS_TOKEN", accessToken).replace("OPEN_ID", openId);
        try {
            result = HttpUtil.get(requestUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WeChatUserInfo weChatUserInfo = JSON.parseObject(result, WeChatUserInfo.class);
        return weChatUserInfo;
    }
}
