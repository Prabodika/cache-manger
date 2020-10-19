package com.cache.manager.test.util;

public enum LevelOneCacheStrategyName {
    lfuCache("lfu"),
    lruCache("lru");

    private String cacheStrategyName;

    LevelOneCacheStrategyName(String cacheStrategyName) {
        this.cacheStrategyName = cacheStrategyName;
    }

    public static LevelOneCacheStrategyName getEnumByName(String name) {

        LevelOneCacheStrategyName levelOneCacheStrategyName=null;
        for (LevelOneCacheStrategyName enumValue : LevelOneCacheStrategyName.values()) {
            if (enumValue.cacheStrategyName.equals(name)) {
                levelOneCacheStrategyName = enumValue;
            }
        }
        return levelOneCacheStrategyName;

    }



}
