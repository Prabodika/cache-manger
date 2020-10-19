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
    private boolean cacheLevelOneIsActive;

    @Value("${cache.level.two.status}")
    private boolean cacheLevelTwoIsActive;

    @Value("${cache.level.one.capacity}")
    private int cacheLevelOneCapacity;

    @Value("${cache.level.two.capacity}")
    private int cacheLevelTwoCapacity;


    public String getCacheLevelOneStrategy() {
        return cacheLevelOneStrategy;
    }

    public String getCacheLevelTwoStrategy() {
        return cacheLevelTwoStrategy;
    }

    public boolean getCacheLevelOneIsActive() {
        return cacheLevelOneIsActive;
    }

    public boolean getCacheLevelTwoIsActive() {
        return cacheLevelTwoIsActive;
    }

    public int isCacheLevelOneCapacity() {
        return cacheLevelOneCapacity;
    }

    public int isCacheLevelTwoCapacity() {
        return cacheLevelTwoCapacity;
    }


}
