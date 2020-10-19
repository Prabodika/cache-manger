package com.cache.manager.test.util;

public enum LevelTwoCacheStrategyName {
    lfuFile("lfu"),
    lruFile("lru");

    private String cacheStrategyName;

    LevelTwoCacheStrategyName(String cacheStrategyName) {
        this.cacheStrategyName = cacheStrategyName;
    }

    public static LevelTwoCacheStrategyName getEnumByName(String name) {

        LevelTwoCacheStrategyName levelTwoCacheStrategyName=null;
        for (LevelTwoCacheStrategyName enumValue : LevelTwoCacheStrategyName.values()) {
            if (enumValue.cacheStrategyName.equals(name)) {
                levelTwoCacheStrategyName = enumValue;
            }
        }
        return levelTwoCacheStrategyName;

    }
}
