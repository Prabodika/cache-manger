package com.cache.manager.test.service.strategy;


import com.cache.manager.test.dao.FileCacheDao;
import com.cache.manager.test.dao.impl.FileSystemLfuCacheDaoImpl;
import com.cache.manager.test.dao.impl.FileSystemLruCacheDaoImpl;
import com.cache.manager.test.util.LevelTwoCacheStrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LevelTwoCacheStrategy {

    private Map<LevelTwoCacheStrategyName, FileCacheDao> strategies;

    @Autowired
    public LevelTwoCacheStrategy() {
        createStrategy();

    }

    /**
     * This method get the cache strategy for given strategy name
     *
     * @param strategyName : cache strategy name
     * @return
     */
    public FileCacheDao findStrategy(LevelTwoCacheStrategyName strategyName) {
        return strategies.get(strategyName);

    }

    /**
     * This method initialize level two cache strategies
     */
    private void createStrategy() {
        strategies = new HashMap<>();
        strategies.put(FileSystemLruCacheDaoImpl.getInstance().getStrategyName(), FileSystemLruCacheDaoImpl.getInstance());
        strategies.put(FileSystemLfuCacheDaoImpl.getInstance().getStrategyName(), FileSystemLfuCacheDaoImpl.getInstance());

    }
}
