package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.FileCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.LevelTwoCacheStrategyName;
import org.springframework.stereotype.Repository;

public class FileSystemLfuCacheDaoImpl implements FileCacheDao {


    private static FileSystemLfuCacheDaoImpl fileSystemLfuCacheDaoImpl = null;

    private FileSystemLfuCacheDaoImpl() { }

    public static FileSystemLfuCacheDaoImpl getInstance() {

        if (fileSystemLfuCacheDaoImpl == null) {
            fileSystemLfuCacheDaoImpl = new FileSystemLfuCacheDaoImpl();
        }
        return fileSystemLfuCacheDaoImpl;
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
        return LevelTwoCacheStrategyName.lfuFile;

    }
}
