package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.ObjectCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.LevelOneCacheStrategyName;

public class LfuObjectCacheDaoImpl implements ObjectCacheDao {

    private static LfuObjectCacheDaoImpl lfuObjectCacheDaoImpl = null;

    private LfuObjectCacheDaoImpl() {
    }

    public static LfuObjectCacheDaoImpl getInstance() {

        if (lfuObjectCacheDaoImpl == null) {
            lfuObjectCacheDaoImpl = new LfuObjectCacheDaoImpl();
        }
        return lfuObjectCacheDaoImpl;
    }

    @Override
    public CacheDomain getCache(String key)
    {
        return null;
    }

    @Override
    public void saveCache(String key, CacheDomain domain) {

    }

    @Override
    public LevelOneCacheStrategyName getStrategyName() {
        return LevelOneCacheStrategyName.lfuCache;
    }


}
