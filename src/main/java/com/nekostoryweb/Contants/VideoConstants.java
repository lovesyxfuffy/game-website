package com.nekostoryweb.contants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
public class VideoConstants {
    private static Map<String,String> configMap = new HashMap<>();

    static {
        configMap.put("0","storyBackground");
        configMap.put("1","operateVideoUrl");
        configMap.put("2","roomVideoUrl");
        configMap.put("3","orderVideoUrl");
        configMap.put("4","propagandaVideoUrl");
    }
    public static Map<String, String> getConfigMap() {
        return configMap;
    }


}
