package com.xxxx.mobile.controller;

import com.xxxx.mobile.bean.intelligentanswer.po.es.EsMobileAnswer;
import com.xxxx.mobile.bean.intelligentanswer.po.jpa.MobileAnswer;
import com.xxxx.mobile.dao.es.MobileAnswerRepository;
import com.xxxx.mobile.dao.jpa.MobileAnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/19 20:24
 */
@RestController
@RequestMapping("/mobileAnswer")
public class MobileAnswerController {

    @Autowired
    private MobileAnswerRepository mobileAnswerRepository;

    @Autowired
    private MobileAnswerDao mobileAnswerDao;

    /**
     * 添加
     * @return
     */
    @RequestMapping("/batchAdd")
    public String batchAdd() {
        int pageNum = 1;
        int beginId = 0;
        int pageSize = 100;
        int operateSize = 0;
        long count = mobileAnswerDao.count();

        while (true){
            Pageable pageable = PageRequest.of(0, pageSize);
            int finalBeginId = beginId;
            Specification<MobileAnswer> confusion=new Specification<MobileAnswer>() {
                @Override
                public Predicate toPredicate(Root<MobileAnswer> root, CriteriaQuery<?> query,
                                             CriteriaBuilder criteriaBuilder) {
                    Path<Integer> id = root.get("id");
                    Predicate ge = criteriaBuilder.greaterThan(id, finalBeginId);
                    return ge;
                }
            };
            Page<MobileAnswer> all = mobileAnswerDao.findAll(confusion, pageable);
            List<MobileAnswer> answers = all.getContent();
            beginId += pageSize;
            if (!CollectionUtils.isEmpty(answers)) {
                operateSize += answers.size();
                Optional<MobileAnswer > mobileAnswer= answers.stream().max(Comparator.comparingInt(MobileAnswer :: getId));
                MobileAnswer maxEmp = mobileAnswer.get();
                beginId = maxEmp.getId();
                List<EsMobileAnswer> esMobileAnswers = answers.stream().map(e -> new EsMobileAnswer(e)).collect(Collectors.toList());
                mobileAnswerRepository.saveAll(esMobileAnswers);
            }

            pageNum++;
            if (operateSize >= count) {
                break;
            }
        }
        return "success";
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestBody EsMobileAnswer esMobileAnswer) {
        mobileAnswerRepository.save(esMobileAnswer);
        return "success";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@RequestBody EsMobileAnswer esMobileAnswer) {
        mobileAnswerRepository.delete(esMobileAnswer);
        return "success";
    }

    /**
     * 局部更新
     * @return
     */
    @RequestMapping("/update")
    public String update(@RequestBody EsMobileAnswer esMobileAnswer) {
        mobileAnswerRepository.save(esMobileAnswer);
        return "success";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("/query")
    public List<EsMobileAnswer> query(@RequestBody EsMobileAnswer esMobileAnswer) {
        List<EsMobileAnswer> esMobileAnswers = mobileAnswerRepository.queryMobileAnswerByQuestionLike(esMobileAnswer.getQuestion());
        return esMobileAnswers;
    }
}
