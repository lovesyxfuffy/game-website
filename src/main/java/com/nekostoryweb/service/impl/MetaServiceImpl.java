package com.nekostoryweb.service.impl;

import com.nekostoryweb.Contants.ConfigMap;
import com.nekostoryweb.Exception.BizException;
import com.nekostoryweb.dao.dto.GameLinkDto;
import com.nekostoryweb.dao.mapper.ConfigMapper;
import com.nekostoryweb.dao.po.Config;
import com.nekostoryweb.service.MetaService;
import lombok.Cleanup;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by yujingyang on 2017/9/20.
 */
@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    ConfigMapper configMapper;

    @Override
    public String saveFile(CommonsMultipartFile file) {
        Properties properties = new Properties();
        try {
            @Cleanup InputStream inputStream = this.getClass().getResourceAsStream("/config/app.properties");
            properties.load(inputStream);
            String savePath = properties.getProperty("savePath");
            String saveFile = savePath + file.getOriginalFilename();
            File newFile = new File(saveFile);
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BizException("读取配置文件错误");
        }
        return file.getOriginalFilename();
    }

    @Override
    public void saveConfig(GameLinkDto gameLinkDto) {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(gameLinkDto.getClass());
        List<Config> configList = new ArrayList<>();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            Config config = new Config();
            config.setConfigName(ConfigMap.getConfigMap().get(propertyDescriptor.getName()));
            config.setConfigKey(propertyDescriptor.getName());
            try {
                Object property = propertyDescriptor.getReadMethod().invoke(gameLinkDto);
                if (property instanceof java.lang.String)
                    config.setConfigValue((String) property);
                else
                    continue;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                throw new BizException("读取配置项错误");
            }
            config.setType("sidebar");
            configList.add(config);
        }

       configMapper.batchInsert(configList);


    }
}
