package com.xxxx.mobile.controller;

import com.xxxx.common.bean.ResponseInfo;
import com.xxxx.common.constant.ResponseCode;
import com.xxxx.mobile.bean.City;
import com.xxxx.mobile.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 09:10
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CityService cityService;

    @GetMapping("/test")
    public ResponseInfo test1(){

        City city = getShanghai();
        // 向 redis 中存入数据
        cityService.saveCity(city);

        // 从 redis 中取数据
        City cityInfo = cityService.getCityByName("上海");

        return new ResponseInfo(cityInfo);
    }

    @GetMapping("/test2")
    public ResponseInfo test2(){
        City city = getBeijing();
        // 向 redis 中存入数据
        cityService.saveCity(city);

        // 从 redis 中取数据, 第一次查询
        City cityInfo = cityService.getCityByName("北京");

        // 从 redis 中取数据, 第二次查询
        cityInfo = cityService.getCityByName("北京");

        // 更新 city 的描述信息后查询
        cityService.updateCityDescription("北京", "想不想去北京玩玩呢？");
        cityInfo = cityService.getCityByName("北京");

        return new ResponseInfo(cityInfo);
    }

    private City getShanghai(){
        return new City(1L, 10L, "上海", "人称魔都的地方");
    }

    private City getBeijing(){
        return new City(2L, 20L, "北京", "中国帝都");
    }
}
