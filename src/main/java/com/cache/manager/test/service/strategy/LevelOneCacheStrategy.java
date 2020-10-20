package com.cache.manager.test.service.strategy;

import com.cache.manager.test.dao.ObjectCacheDao;
import com.cache.manager.test.dao.impl.LfuObjectCacheDaoImpl;
import com.cache.manager.test.dao.impl.LruObjectCacheDaoImpl;
import com.cache.manager.test.util.Configurations;
import com.cache.manager.test.util.LevelOneCacheStrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LevelOneCacheStrategy {

    private Configurations configurations;

    private Map<LevelOneCacheStrategyName, ObjectCacheDao> strategies;

    @Autowired
    public LevelOneCacheStrategy(Configurations configurations) {

        this.configurations=configurations;
        createStrategy();

    }

    /**
     * This method get the cache strategy for given strategy name
     *
     * @param strategyName : cache strategy name
     * @return
     */
    public ObjectCacheDao findStrategy(LevelOneCacheStrategyName strategyName) {
        return strategies.get(strategyName);

    }

    /**
     * This method initialize level one cache strategies
     */
    private void createStrategy() {
        strategies = new HashMap<>();
        LfuObjectCacheDaoImpl lfu= new LfuObjectCacheDaoImpl(configurations.getCacheLevelOneCapacity());
        strategies.put(lfu.getStrategyName(), lfu);
        LruObjectCacheDaoImpl lru= new LruObjectCacheDaoImpl(configurations.getCacheLevelOneCapacity());
        strategies.put(lru.getStrategyName(),lru );

    }


}
