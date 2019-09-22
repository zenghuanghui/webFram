package com.xxxx.common.util;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class WeChatUserInfoUtil {

    public final static String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESSTOKEN&openid=OPENID";

    public static final String ACCESSTOKEN = "25_91tugdc0QXy17bZBcMRFxsLl7HAFgEvDnfApPWOssMGWqYO_EZ6tdDOKDD2c3RvxZAl7yMolUlq3RrIwaZs6MBYwMotPQ98FhuEVUPUBuZko5Ob8nzGt3RHtI7i9rjsn4HezhL1Kkvj9qDKUGJQhAIABEL";
    public static final String  OPENID = "oGjAbs0Rkyz3IvXAss23QqXbM3mk";


    public static void main(String[] args) {
        System.out.println(getUserInfo());
    }
    public static String getUserInfo(){
        String result = null;
        String requestUrl = USER_INFO_URL.replace("ACCESSTOKEN", ACCESSTOKEN).replace("OPENID", OPENID);
        System.out.println(requestUrl);
        try {
            result = HttpUtil.get(requestUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        jsonObject = JSONObject.parseObject(result);
        return result;
    }
}
