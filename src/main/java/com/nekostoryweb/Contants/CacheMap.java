package com.nekostoryweb.contants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/29.
 */
public class CacheMap {
    private static Map<String,String> cacheMap = new HashMap<>();

    public static Map<String, String> getCacheMap() {
        return cacheMap;
    }

    public static void setCacheMap(Map<String, String> cacheMap) {
        CacheMap.cacheMap = cacheMap;
    }
}
