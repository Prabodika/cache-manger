package com.cache.manager.test.dao;

import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.LevelOneCacheStrategyName;
import com.cache.manager.test.util.LevelTwoCacheStrategyName;

public interface FileCacheDao {

    CacheDomain getCache(String key);

    void saveCache(String key,CacheDomain domain);

    public LevelTwoCacheStrategyName getStrategyName();

}
