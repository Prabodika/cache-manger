package com.cache.manager.test.service.strategy;


import com.cache.manager.test.dao.FileCacheDao;
import com.cache.manager.test.dao.impl.*;
import com.cache.manager.test.exception.UnsupportedStrategyException;
import com.cache.manager.test.util.Configurations;
import com.cache.manager.test.util.LevelTwoCacheStrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LevelTwoCacheStrategy {

    private Configurations configurations;

    private Map<LevelTwoCacheStrategyName, FileCacheDao> strategies;

    @Autowired
    public LevelTwoCacheStrategy(Configurations configurations) {
        this.configurations=configurations;
        createStrategy();

    }

    /**
     * This method get the cache strategy for given strategy name
     *
     * @param strategyName : cache strategy name
     * @return
     */
    public FileCacheDao findStrategy(LevelTwoCacheStrategyName strategyName) {
        FileCacheDao fileCacheDao= strategies.get(strategyName);
        if(null==fileCacheDao){
            throw new UnsupportedStrategyException();
        }
        return fileCacheDao;

    }

    /**
     * This method initialize level two cache strategies
     */
    private void createStrategy() {

        strategies = new HashMap<>();
        FileSystemLfuCacheDaoImpl lfu= new FileSystemLfuCacheDaoImpl(configurations.getCacheLevelTwoCapacity());
        strategies.put(lfu.getStrategyName(), lfu);
        FileSystemLruCacheDaoImpl lru= new FileSystemLruCacheDaoImpl(configurations.getCacheLevelTwoCapacity());
        strategies.put(lru.getStrategyName(),lru );

    }
}
