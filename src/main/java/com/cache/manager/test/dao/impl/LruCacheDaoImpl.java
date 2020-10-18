package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.CacheDao;
import com.cache.manager.test.domain.CacheDomain;
import org.springframework.stereotype.Repository;

@Repository("lruCache")
public class LruCacheDaoImpl implements CacheDao {

    @Override
    public CacheDomain getCache(String key) {
        return null;
    }

    @Override
    public void saveCache(String key, CacheDomain domain) {

    }
}
