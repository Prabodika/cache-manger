package com.cache.manager.test.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configurations {

    @Value("${cache.level.one.strategy}")
    private String cacheLevelOneStrategy;

    @Value("${cache.level.two.strategy}")
    private String cacheLevelTwoStrategy;

    @Value("${cache.level.one.status}")
    private String cacheLevelOneStatus;

    @Value("${cache.level.two.status}")
    private String cacheLevelTwoStatus;



    public String getCacheLevelOneStrategy() {
        return cacheLevelOneStrategy;
    }

    public String getCacheLevelTwoStrategy() {
        return cacheLevelTwoStrategy;
    }

    public String getCacheLevelOneStatus() {
        return cacheLevelOneStatus;
    }

    public String getCacheLevelTwoStatus() {
        return cacheLevelTwoStatus;
    }
}
