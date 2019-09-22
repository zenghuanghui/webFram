package com.xxxx.mobile.service.impl;

import com.xxxx.mobile.dao.jpa.UserInfoDao;
import com.xxxx.mobile.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    @Transactional
    public void saveWeChatUserInfo(String openId) {
        userInfoDao.saveUserInfo(openId);
    }
}
