package com.nekostoryweb.service.manage.impl;

import com.nekostoryweb.contants.ConfigMap;
import com.nekostoryweb.Exception.BizException;
import com.nekostoryweb.dao.mapper.ConfigMapper;
import com.nekostoryweb.dao.po.Config;
import com.nekostoryweb.service.manage.MetaService;
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
        if (file == null || file.getSize() == 0)
            return null;
        try {
            @Cleanup InputStream inputStream = this.getClass().getResourceAsStream("/config/app.properties");
            properties.load(inputStream);
            String savePath = properties.getProperty("savePath");
            String saveFile = savePath + file.getOriginalFilename();
            if ("".equals(file.getOriginalFilename()) || file.getOriginalFilename() == null)
                return null;
            File newFile = new File(saveFile);

            file.transferTo(newFile);
            File afterFile = new File(saveFile);
            while (!afterFile.exists()) {
                Thread.sleep(100);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new BizException("读取配置文件错误");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return file.getOriginalFilename();
    }

    @Override
    public void saveConfig(Object dto, String type) {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(dto.getClass());
        List<Config> configList = new ArrayList<>();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            Config config = new Config();
            config.setConfigName(ConfigMap.getConfigMap().get(propertyDescriptor.getName()));
            config.setConfigKey(propertyDescriptor.getName());
            try {
                Object property = propertyDescriptor.getReadMethod().invoke(dto);
                if (property == null)
                    continue;
                if (property instanceof java.lang.String && (!"".equals(property))) {

                    config.setConfigValue((String) property);
                } else
                    continue;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                throw new BizException("读取配置项错误");
            }
            config.setType(type);
            configList.add(config);
        }

        configMapper.batchInsert(configList);


    }
}
