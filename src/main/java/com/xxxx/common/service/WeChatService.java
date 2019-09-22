package com.xxxx.common.service;

import com.xxxx.common.bean.WeChat.WeChatUserInfo;

public interface WeChatService {

    void freshAccessToken();

    String getAccessToken();

    WeChatUserInfo getWeChatUserInfo(String openId);
}
