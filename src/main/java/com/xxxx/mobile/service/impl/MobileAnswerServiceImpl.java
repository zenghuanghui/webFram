package com.xxxx.mobile.service.impl;

import com.xxxx.mobile.bean.intelligentanswer.po.es.EsMobileAnswer;
import com.xxxx.mobile.dao.es.MobileAnswerRepository;
import com.xxxx.mobile.service.MobileAnswerService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MobileAnswerServiceImpl implements MobileAnswerService {

    @Autowired
    private MobileAnswerRepository mobileAnswerRepository;
    @Override
    public String getAnswer(String question) {
        try {
            question = question.replace(" ",  "");
            // 分页参数
            Pageable pageable = PageRequest.of(0, 10);

            // 分数，并自动按分排序
            MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("question", question);
            FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(queryBuilder, ScoreFunctionBuilders.weightFactorFunction(100000));

            // 分数、分页
            SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable)
                    .withQuery(functionScoreQueryBuilder).build();
            Page<EsMobileAnswer> searchPageResults = mobileAnswerRepository.search(searchQuery);
            List<EsMobileAnswer> esMobileAnswer = searchPageResults.getContent();
            if (CollectionUtils.isEmpty(esMobileAnswer)) {
                return null;
            }
            StringBuilder sbd = new StringBuilder(esMobileAnswer.get(0).getAnswer());
            sbd.append("\n");
            sbd.append("\n更多类似问题:");
            int i = 1;
            for (EsMobileAnswer mobileAnswer : esMobileAnswer) {
                sbd.append("\n");
                sbd.append(i);
                sbd.append(". ");
                sbd.append("<a href='");
                sbd.append(mobileAnswer.getOriginUrl());
                sbd.append("'>");
                sbd.append(mobileAnswer.getQuestion());
                sbd.append("</a>");
                i++;
            }
            return sbd.toString();
        }catch (Exception e){
            return null;
        }
    }
}
