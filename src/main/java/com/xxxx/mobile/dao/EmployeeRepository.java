package com.xxxx.mobile.dao;

import com.xxxx.mobile.bean.intelligentanswer.po.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/19 20:23
 */
@Component
public interface  EmployeeRepository extends ElasticsearchRepository<Employee,String> {
    /**
     * 查询雇员信息
     * @param id
     * @return
     */
    Employee queryEmployeeById(String id);
}
