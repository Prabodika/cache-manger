package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.FileCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.FileDataWriter;
import com.cache.manager.test.util.LevelTwoCacheStrategyName;

import java.util.HashMap;
import java.util.LinkedList;

public class FileSystemLfuCacheDaoImpl implements FileCacheDao {

    //cache key value
    HashMap<String, String> key_Filename;
    HashMap<String, Integer> key_frequency;
    HashMap<Integer, LinkedList<String>> frequency_keyList;
    int capacity;
    int min = -1;


    public FileSystemLfuCacheDaoImpl(int capacity) {
        this.capacity = capacity;
        key_Filename = new HashMap<>();
        key_frequency = new HashMap<>();
        frequency_keyList = new HashMap<>();
        frequency_keyList.put(1, new LinkedList<>());

    }


    /**
     * get cache
     *
     * @param key
     * @return
     */
    @Override
    public CacheDomain getCache(String key) {

        CacheDomain domain = null;

        if (key_Filename.containsKey(key)) {

            String fileName = key_Filename.get(key);

            int frq = key_frequency.get(key);
            key_frequency.put(key, frq + 1);

            LinkedList<String> frqKeySet = frequency_keyList.get(frq);
            frqKeySet.remove(key);

            if (frq == min && frqKeySet.isEmpty()) {
                min++;
            }

            LinkedList<String> frqKeyListNextFrq = frequency_keyList.get(frq + 1);

            if (frqKeyListNextFrq==null) {
                frqKeyListNextFrq = new LinkedList<>();
                frqKeyListNextFrq.add(key);
                frequency_keyList.put(frq + 1, frqKeyListNextFrq);
            } else {
                frqKeyListNextFrq.add(key);
            }
            domain = FileDataWriter.getInstance().readFile(fileName);

        }

        return domain;
    }

    /**
     * Save cache
     *
     * @param key
     * @param domain
     */
    @Override
    public void saveCache(String key, CacheDomain domain) {

        if (key_Filename.containsKey(key)) {

            String fileName = key_Filename.get(key);
            FileDataWriter.getInstance().deleteFile(fileName);
            FileDataWriter.getInstance().writeToFile(fileName, domain);
            getCache(key);

        } else {

            if (capacity == key_Filename.size()) {

                LinkedList<String> frqList = frequency_keyList.get(min);
                String lfuKey = frqList.removeFirst();

                key_frequency.remove(lfuKey);
                String fileToRemove = key_Filename.remove(lfuKey);
                //remove file
                FileDataWriter.getInstance().deleteFile(fileToRemove);

            }

            min = 1;
            //file name and the key are both same
            key_Filename.put(key, key);
            key_frequency.put(key, min);
            frequency_keyList.get(min).addLast(key);
            FileDataWriter.getInstance().writeToFile(key, domain);

        }
    }

    @Override
    public LevelTwoCacheStrategyName getStrategyName() {
        return LevelTwoCacheStrategyName.lfuFile;

    }
}
