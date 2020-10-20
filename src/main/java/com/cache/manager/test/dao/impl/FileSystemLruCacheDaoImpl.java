package com.cache.manager.test.dao.impl;

import com.cache.manager.test.dao.FileCacheDao;
import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.util.FileDataWriter;
import com.cache.manager.test.util.LevelTwoCacheStrategyName;

import java.util.*;

public class FileSystemLruCacheDaoImpl implements FileCacheDao {

    private final int capacity;
    LinkedList<String> linkedListKeys;
    Map<String, String> key_fileName;


    public FileSystemLruCacheDaoImpl(int capacity) {

        key_fileName = new HashMap<>(capacity);
        linkedListKeys = new LinkedList<>();
        this.capacity = capacity;
    }


    /**
     * This method return the cacheDomain object
     *
     * @param key
     * @return
     */
    @Override
    public CacheDomain getCache(String key) {

        String fileName = key_fileName.get(key);
        CacheDomain domain = null;

        if (fileName != null) {
            linkedListKeys.remove(key);
            linkedListKeys.addLast(key);
            domain = FileDataWriter.getInstance().readFile(fileName);
        }

        return domain;

    }

    /**
     * @param key
     * @param domain
     */
    @Override
    public void saveCache(String key, CacheDomain domain) {

        String fileName = key_fileName.get(key);

        if (fileName != null) {
            linkedListKeys.remove(key);
            linkedListKeys.addLast(key);
            FileDataWriter.getInstance().deleteFile(fileName);

        } else {

            if (capacity == linkedListKeys.size()) {
                String keyLeastRecent = linkedListKeys.removeFirst();
                String leastRecentFileName = key_fileName.get(keyLeastRecent);
                FileDataWriter.getInstance().deleteFile(leastRecentFileName);
                key_fileName.remove(keyLeastRecent);

            }
            //here filename and the key are both equals later we can change the name accordingly
            fileName = key;
            key_fileName.put(key, fileName);
            linkedListKeys.addLast(key);

        }

        FileDataWriter.getInstance().writeToFile(fileName, domain);


    }


    @Override
    public LevelTwoCacheStrategyName getStrategyName() {
        return LevelTwoCacheStrategyName.lruFile;
    }


}
