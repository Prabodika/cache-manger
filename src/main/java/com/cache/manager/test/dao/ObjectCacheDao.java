package com.cache.manager.test.dao;

import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.service.strategy.LevelOneCacheStrategy;
import com.cache.manager.test.util.LevelOneCacheStrategyName;

public interface ObjectCacheDao {

    CacheDomain getCache(String key);

    void saveCache(String key,CacheDomain domain);

    public LevelOneCacheStrategyName getStrategyName();
}
