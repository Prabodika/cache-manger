package com.cache.manager.test.service.impl;

import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.dto.CacheDto;
import com.cache.manager.test.service.CacheService;
import com.cache.manager.test.service.strategy.LevelOneCacheStrategy;
import com.cache.manager.test.service.strategy.LevelTwoCacheStrategy;
import com.cache.manager.test.util.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.stream.IIOByteBuffer;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private Configurations configurations;

    @Autowired
    private LevelOneCacheStrategy levelOneCacheStrategy;

    @Autowired
    private LevelTwoCacheStrategy levelTwoCacheStrategy;

    /**
     * This method get cache details by key
     * @param key : key to get cache details
     * @return CacheDto: cache details
     */
    @Override
    public CacheDto getCache(String key) {
        return null;
    }

    /**
     * This method save cache details by key
     * @param cacheDto : cache data
     */
    @Override
    public void saveCache(CacheDto cacheDto) {

    }
}
