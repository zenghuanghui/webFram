package com.xxxx.common.util;

import com.alibaba.fastjson.JSONObject;
import com.xxxx.common.bean.WeChat.AccessToken;

import java.io.IOException;

public class AccessTokenUtil {


    // 获取access_token的接口地址（GET） 限2000（次/天）
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    // 创建菜单
    public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    // 查询自定义菜单
    public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    // 删除自定义菜单
    public static final String MENU_DELTE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    // 获取jsapi_ticket的接口地址（GET） 限2000（次/天）
    public static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    // 发送模板消息
    public static final String SEND_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    // 微信appid
    public final static String APPID = "wx6acac99c8ebaea70";
    // 微信wx_secret
    public final static String SECERT = "3b02536577c0e9335c422dbac9e03a55";



    public static void main(String[] args) {
        System.out.println("------------------->" + getToken(APPID, SECERT));
    }

    /**
     * 获得Token
     *
     * @param appId
     * @param secret
     * @return
     */
    public static String getToken(String appId, String secret) {
        AccessToken accessTocken = getToken(appId, secret, System.currentTimeMillis() / 1000);
        return accessTocken.getAccessToken();
    }

    /**
     * 获取access_token
     *
     * @param appid
     *            凭证
     * @param appsecret
     *            密钥
     * @return
     */
    public static AccessToken getToken(String appid, String appsecret, long currentTime) {
        AccessToken accessToken = null;
        // 调用接口获取token
        String requestUrl = ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            accessToken = new AccessToken();
            accessToken.setAccessToken(jsonObject.getString("access_token"));
            // 正常过期时间是7200秒，此处设置3600秒读取一次
            // 一天有获取2000次的限制 ,设置1小时获取一次AccessToken防止超出请求限制
            accessToken.setExpiresIn(jsonObject.getIntValue("expires_in") / 2);
            accessToken.setAddTime(currentTime);
        }
        return accessToken;
    }

    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl
     *            请求地址
     * @param requestMethod
     *            请求方式（GET、POST）
     * @param outputStr
     *            提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    private static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        String result = null;
        try {
            result = HttpUtil.get(requestUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        jsonObject = JSONObject.parseObject(result);
        return jsonObject;
    }
}
