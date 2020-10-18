package com.cache.manager.test.service.strategy;


import com.cache.manager.test.dao.CacheDao;
import com.cache.manager.test.util.LevelOneCacheStrategyName;
import com.cache.manager.test.util.LevelTwoCacheStrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
public class LevelTwoCacheStrategy {

    private Map<LevelTwoCacheStrategyName, CacheDao> strategies;

    @Autowired
    @Qualifier("file")
    private CacheDao file;

    @Autowired
    public LevelTwoCacheStrategy() {
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
     * This method initialize level two cache strategies
     */
    private void createStrategy() {
        strategies = new HashMap<>();
        strategies.put(LevelTwoCacheStrategyName.file,file);

    }
}
