package com.cache.manager.test.service.impl;

import com.cache.manager.test.dao.FileCacheDao;
import com.cache.manager.test.dao.ObjectCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.dto.CacheDto;
import com.cache.manager.test.mappers.*;
import com.cache.manager.test.service.CacheService;
import com.cache.manager.test.service.strategy.LevelOneCacheStrategy;
import com.cache.manager.test.service.strategy.LevelTwoCacheStrategy;
import com.cache.manager.test.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {


    @Autowired
    private LevelOneCacheStrategy levelOneCacheStrategy;

    @Autowired
    private LevelTwoCacheStrategy levelTwoCacheStrategy;

    @Autowired
    private Configurations configurations;





    /**
     * This method get cache details by key
     * @param key : key to get cache details
     * @return CacheDto: cache details
     */
    @Override
    public CacheDto getCache(String key) {

        CacheDomain domain=null;
        if(configurations.getCacheLevelOneIsActive()){
            LevelOneCacheStrategyName strategyName= LevelOneCacheStrategyName.getEnumByName(configurations.getCacheLevelOneStrategy());
            ObjectCacheDao objectCacheDao= levelOneCacheStrategy.findStrategy(strategyName);
            domain= objectCacheDao.getCache(key);
        }
        if(configurations.getCacheLevelTwoIsActive()||(null==domain)){
            LevelTwoCacheStrategyName strategyTwo= LevelTwoCacheStrategyName.getEnumByName(configurations.getCacheLevelTwoStrategy());
            FileCacheDao dao= levelTwoCacheStrategy.findStrategy(strategyTwo);
            domain= dao.getCache(key);

        }

        return   CacheDtoMapper.INSTANCE.CacheDomainToDto(domain);
    }

    /**
     * This method save cache details by key
     * @param cacheDto : cache data
     */
    @Override
    public void saveCache(CacheDto cacheDto) {

        if(configurations.getCacheLevelOneIsActive()){
            LevelOneCacheStrategyName strategyName= LevelOneCacheStrategyName.getEnumByName(configurations.getCacheLevelOneStrategy());
            ObjectCacheDao objectCacheDao= levelOneCacheStrategy.findStrategy(strategyName);
            objectCacheDao.saveCache(cacheDto.getId(),  CacheDomainMapper.INSTANCE.CacheDtoToDomain(cacheDto));
        }
        if(configurations.getCacheLevelTwoIsActive()){
            LevelTwoCacheStrategyName strategyTwo= LevelTwoCacheStrategyName.getEnumByName(configurations.getCacheLevelTwoStrategy());
            FileCacheDao fileDao= levelTwoCacheStrategy.findStrategy(strategyTwo);
           fileDao.saveCache(cacheDto.getId(),  CacheDomainMapper.INSTANCE.CacheDtoToDomain(cacheDto));         ;

        }

    }





}
