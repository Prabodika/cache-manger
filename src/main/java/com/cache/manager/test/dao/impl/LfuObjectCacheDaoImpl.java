package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.ObjectCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.LevelOneCacheStrategyName;

import java.util.HashMap;
import java.util.LinkedList;

public class LfuObjectCacheDaoImpl implements ObjectCacheDao {

    //cache key value
    HashMap<String, CacheDomain> key_values;
    HashMap<String, Integer> key_frequency;
    HashMap<Integer, LinkedList<String>> frequency_keyList;
    int capacity;
    int min = -1;

    public LfuObjectCacheDaoImpl(int capacity) {
        this.capacity = capacity;
        key_values = new HashMap<>();
        key_frequency = new HashMap<>();
        frequency_keyList = new HashMap<>();
        frequency_keyList.put(1, new LinkedList<>());
    }


    @Override
    public CacheDomain getCache(String key) {
        CacheDomain domain = key_values.get(key);

        if (null != domain) {
            int freq = key_frequency.get(key);
            key_frequency.put(key, freq + 1);

            LinkedList<String> currentSet = frequency_keyList.get(freq);
            // removing the key from current hashset
            currentSet.remove(key);
            LinkedList<String> newList = frequency_keyList.get(freq + 1);

            if (newList == null) {
                newList = new LinkedList<>();
                newList.addLast(key);
                frequency_keyList.put(freq + 1, newList);
            } else {
                newList.addLast(key);
            }

            if (min == freq && currentSet.isEmpty()) {
                min++;
            }

        }

        return domain;
    }


    @Override
    public void saveCache(String key, CacheDomain domain) {

        //modifying existing key
        if (key_values.containsKey(key)) {

            key_values.put(key, domain);
            getCache(key);

        } else {
            //new key comes capacity exceed
            if (key_values.size() == capacity) {

                String keyToRemove = frequency_keyList.get(min).removeFirst();
                key_values.remove(keyToRemove);
                key_frequency.remove(keyToRemove);

            }
            min = 1;
            key_values.put(key, domain);
            key_frequency.put(key, min);
            frequency_keyList.get(min).addLast(key);


        }


    }

    @Override
    public LevelOneCacheStrategyName getStrategyName() {
        return LevelOneCacheStrategyName.lfuCache;
    }


}
