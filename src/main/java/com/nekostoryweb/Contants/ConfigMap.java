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

        configMap.put("storyBackground","故事背景视频地址");
        configMap.put("operateVideoUrl","玩法-经营视频地址");
        configMap.put("roomVideoUrl","玩法-房间视频地址");
        configMap.put("orderVideoUrl","玩法-订单视频地址");
        configMap.put("propagandaVideoUrl","玩法-宣传视频地址");

        configMap.put("customerService","客服电话");
        configMap.put("qqGroupList","qq群");
        configMap.put("wechatOfficialName","官方微博名称");
        configMap.put("weiboOfficialLink","官方微博链接");
        configMap.put("tiebaUrl","贴吧链接");
        configMap.put("wechatOfficialUrl","微信官方二维码链接");
        configMap.put("weiboOfficialUrl","微博官方二维码链接");



        configMap.put("aboutUs","关于我们");
        configMap.put("userAgreement","用户协议");
        configMap.put("contactUs","联系我们");
        configMap.put("cooperation","商务合作");



    }

    public static Map<String, String> getConfigMap(){
        return configMap;
    }
}
