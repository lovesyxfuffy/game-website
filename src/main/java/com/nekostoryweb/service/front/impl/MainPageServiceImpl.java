package com.nekostoryweb.service.front.impl;

import com.nekostoryweb.Contants.VideoConstants;
import com.nekostoryweb.dao.mapper.ConfigMapper;
import com.nekostoryweb.dao.po.Config;
import com.nekostoryweb.dao.po.ConfigExample;
import com.nekostoryweb.service.front.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
@Service
public class MainPageServiceImpl implements MainPageService {
    @Autowired
    ConfigMapper configMapper;

    private Config getConfigValue(String configKey) {
        ConfigExample configExample = new ConfigExample();
        configExample.createCriteria().andConfigKeyEqualTo(configKey);
        return configMapper.selectByExample(configExample).get(0);
    }

    @Override
    public String getVideoConfig(Integer typeCode) {
        Config config = getConfigValue(VideoConstants.getConfigMap().get(String.valueOf(typeCode)));
        return config.getConfigValue();
    }

    @Override
    public Map<String, Object> getConfigs() {
        List<Config> sqlResult = configMapper.selectByExample(new ConfigExample());
        Map<String, Object> configs = new HashMap<>();
        for (Config config : sqlResult) {
            configs.put(config.getConfigKey(),config.getConfigValue());
        }
        String qqGroupList = (String) configs.get("qqGroupList");
        configs.put("qqGroupList",qqGroupList.split(","));
        Map<String,String> weiboOfficial = new HashMap<>();
        weiboOfficial.put("name", (String) configs.get("weiboOfficialName"));
        weiboOfficial.put("QRCodeUrl", (String) configs.get("weiboOfficialUrl"));
        weiboOfficial.put("link", (String) configs.get("weiboOfficialLink"));
        configs.put("weiboOfficial",weiboOfficial);

        Map<String,String> wechatOfficial = new HashMap<>();
        wechatOfficial.put("name", (String) configs.get("wechatOfficialName"));
        wechatOfficial.put("QRCodeUrl", (String) configs.get("wechatOfficialUrl"));
        configs.put("wechatOfficial",wechatOfficial);

        return configs;
    }

}
