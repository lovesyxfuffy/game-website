package com.nekostoryweb.service;

import com.nekostoryweb.dao.dto.GameLinkDto;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by yujingyang on 2017/9/20.
 */
public interface MetaService {
    String saveFile(CommonsMultipartFile file);



    void saveConfig(Object dto, String type);
}
