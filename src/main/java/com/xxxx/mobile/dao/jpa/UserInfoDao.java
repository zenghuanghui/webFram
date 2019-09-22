package com.xxxx.mobile.dao.jpa;

import com.xxxx.mobile.bean.intelligentanswer.po.jpa.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:15
 */
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {

    @Modifying
    @Query(value = "INSERT INTO t_user_info (open_id,    create_time) VALUE (?1, now()) ON DUPLICATE KEY UPDATE last_access_time = now()",nativeQuery = true)
    void saveUserInfo(String openId);
}
