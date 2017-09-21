package com.nekostoryweb.Contants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/20.
 */
public class ConfigMap {
    static final Map<String,String> configMap = new HashMap<>();

    static {
        configMap.put("iosDownloadUrl","IOS下载地址");
        configMap.put("androidDownloadUrl","安卓下载地址");
        configMap.put("pcDownloadUrl","PC版本下载地址");
        configMap.put("mainPageVideoUrl","首页视频地址");
        configMap.put("QRCodeUrl","游戏二维码地址");

    }

    public static Map<String, String> getConfigMap(){
        return configMap;
    }
}
