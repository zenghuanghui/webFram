package com.xxxx.mobile.dao;

import com.xxxx.mobile.bean.intelligentanswer.po.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 10:15
 */
@Repository
public interface QuestionBankDao extends JpaRepository<QuestionBank, Integer> {

    @Query("SELECT u.answer FROM QuestionBank u WHERE u.question LIKE CONCAT('%', ?1,'%')")
    String findAnswer(@Param("question") String question);
}
