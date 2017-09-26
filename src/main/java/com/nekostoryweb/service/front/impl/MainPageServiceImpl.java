package com.nekostoryweb.service.front.impl;

import com.nekostoryweb.Contants.VideoConstants;
import com.nekostoryweb.dao.mapper.ConfigMapper;
import com.nekostoryweb.dao.po.Config;
import com.nekostoryweb.dao.po.ConfigExample;
import com.nekostoryweb.service.front.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujingyang on 2017/9/26.
 */
@Service
public class MainPageServiceImpl implements MainPageService {
    @Autowired
    ConfigMapper configMapper;

    private Config getConfigValue(String configKey){
        ConfigExample configExample = new ConfigExample();
        configExample.createCriteria().andConfigKeyEqualTo(configKey);
        return configMapper.selectByExample(configExample).get(0);
    }

    @Override
    public String getVideoConfig(Integer typeCode){
        Config config = getConfigValue(VideoConstants.getConfigMap().get(typeCode));
        return config.getConfigValue();
    }

}
