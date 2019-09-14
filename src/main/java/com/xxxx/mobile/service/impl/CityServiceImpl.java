package com.xxxx.mobile.service.impl;

import com.xxxx.mobile.bean.City;
import com.xxxx.mobile.service.CityService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {


    @Cacheable(value = "city", key="'cityName_'+#city.cityName")
    public void saveCity(City city){
    }

    @Cacheable(value = "city", key="'cityName_'+#cityName")
    public City getCityByName(String cityName){
        return new City(1L, 10L, "上海", "人称魔都的地方");
    }

    @CachePut(value = "city", key="'cityName_'+#cityName")
    public City updateCityDescription(String cityName, String description){
        return new City(1L, 10L, cityName, description);
    }

}
