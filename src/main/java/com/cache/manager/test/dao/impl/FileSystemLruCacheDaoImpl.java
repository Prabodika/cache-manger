package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.FileCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.LevelTwoCacheStrategyName;

public class FileSystemLruCacheDaoImpl implements FileCacheDao {

    private static FileSystemLruCacheDaoImpl fileSystemLruCacheDaoImpl = null;

    private FileSystemLruCacheDaoImpl() { }

    public static FileSystemLruCacheDaoImpl getInstance() {

        if (fileSystemLruCacheDaoImpl == null) {
            fileSystemLruCacheDaoImpl = new FileSystemLruCacheDaoImpl();
        }
        return fileSystemLruCacheDaoImpl;
    }

    @Override
    public CacheDomain getCache(String key) {
        return null;
    }

    @Override
    public void saveCache(String key, CacheDomain domain) {

    }

    @Override
    public LevelTwoCacheStrategyName getStrategyName() {
        return LevelTwoCacheStrategyName.lruFile;
    }
}
