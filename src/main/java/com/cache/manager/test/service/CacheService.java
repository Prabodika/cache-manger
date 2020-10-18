package com.cache.manager.test.service;

import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.dto.CacheDto;

public interface CacheService {

     CacheDto getCache(String key);

     void saveCache(CacheDto cacheDto);
}
