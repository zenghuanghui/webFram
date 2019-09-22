package com.xxxx.mobile.dao.es;

import com.xxxx.mobile.bean.intelligentanswer.po.es.EsMobileAnswer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/19 20:23
 */
@Component
public interface MobileAnswerRepository extends ElasticsearchRepository<EsMobileAnswer, String> {

    List<EsMobileAnswer> queryMobileAnswerByQuestionLike(String question);
}
