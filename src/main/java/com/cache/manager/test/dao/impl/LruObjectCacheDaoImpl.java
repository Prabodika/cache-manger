package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.ObjectCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.LevelOneCacheStrategyName;

import java.util.*;

public class LruObjectCacheDaoImpl implements ObjectCacheDao {

    private final int capacity;
    LinkedList<String> linkedList;
    Map<String, CacheDomain> map;

    public LruObjectCacheDaoImpl(int capacity) {

        map = new HashMap<>(capacity);
        linkedList = new LinkedList<>();
        this.capacity = capacity;
    }

    /**
     * This method get the cacheDomain
     *
     * @param key
     * @return
     */
    @Override
    public CacheDomain getCache(String key) {

        CacheDomain domain = map.get(key);
        if (domain != null) {
            linkedList.remove(key);
            linkedList.addLast(key);
        }
        return domain;
    }

    /**
     * This method save the cache
     *
     * @param key
     * @param domain
     */
    @Override
    public void saveCache(String key, CacheDomain domain) {

        CacheDomain currentDomain = map.get(key);

        if (currentDomain != null) {

            linkedList.remove(key);
            linkedList.addLast(key);
            map.put(key, domain);

        } else {
            if (map.size() == capacity) {
                String firstElement = linkedList.removeFirst();
                map.remove(firstElement);
            }

            map.put(key, domain);
            linkedList.addLast(key);
        }

    }

    /**
     * This method get the cache strategy
     *
     * @return
     */

    @Override
    public LevelOneCacheStrategyName getStrategyName() {
        return LevelOneCacheStrategyName.lruCache;
    }


}
