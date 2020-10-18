package com.cache.manager.test.service.strategy;

import com.cache.manager.test.dao.CacheDao;
import com.cache.manager.test.util.LevelOneCacheStrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
public class LevelOneCacheStrategy {


    @Autowired
    @Qualifier("lfuCache")
    private CacheDao lfuCache;
    @Qualifier("lruCache")
    private CacheDao lruCache;

    private Map<LevelOneCacheStrategyName, CacheDao> strategies;

    @Autowired
    public LevelOneCacheStrategy() {
        createStrategy();

    }

    /**
     * This method get the cache strategy for given strategy name
     * @param strategyName : cache strategy name
     * @return
     */
    public CacheDao findStrategy(LevelOneCacheStrategyName strategyName) {
        return strategies.get(strategyName);

    }

    /**
     * This method initialize level one cache strategies
     */
    private void createStrategy() {
        strategies = new HashMap<>();
        strategies.put(LevelOneCacheStrategyName.lfuCache,lfuCache);
        strategies.put(LevelOneCacheStrategyName.lruCache,lruCache);


    }



}
