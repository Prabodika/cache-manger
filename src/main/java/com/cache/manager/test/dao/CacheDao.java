package com.cache.manager.test.dao;

import com.cache.manager.test.domain.CacheDomain;

public interface CacheDao {

    CacheDomain getCache(String key);

    void saveCache(String key,CacheDomain domain);
}
