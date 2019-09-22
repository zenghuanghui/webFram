package com.xxxx.mobile.dao.jpa;

import com.xxxx.mobile.bean.intelligentanswer.po.jpa.UserQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:15
 */
@Repository
public interface UserQuestionDao extends JpaRepository<UserQuestion, Integer> {
}
