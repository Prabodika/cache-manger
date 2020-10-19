package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.ObjectCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.LevelOneCacheStrategyName;
import org.springframework.stereotype.Repository;

public class LruObjectCacheDaoImpl implements ObjectCacheDao {

    private static LruObjectCacheDaoImpl lruObjectCacheDaoImpl = null;

    private LruObjectCacheDaoImpl() {}

    public static LruObjectCacheDaoImpl getInstance() {
        if (lruObjectCacheDaoImpl == null) {
            lruObjectCacheDaoImpl = new LruObjectCacheDaoImpl();
        }
        return lruObjectCacheDaoImpl;
    }



    @Override
    public CacheDomain getCache(String key) {

        return null;
    }

    @Override
    public void saveCache(String key, CacheDomain domain) {

    }

    @Override
    public LevelOneCacheStrategyName getStrategyName() {
        return LevelOneCacheStrategyName.lruCache;
    }
}
