package com.nekostoryweb.controller;

import com.nekostoryweb.Exception.BizException;
import com.nekostoryweb.dao.dto.GameLinkDto;
import com.nekostoryweb.service.MetaService;
import com.nekostoryweb.utils.WebUtil;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yujingyang on 2017/9/20.
 */
@Controller
@RequestMapping("/api/metaManage")
public class MetaManageController {
    @Autowired
    private MetaService metaService;

    private final static String staticFilePath = "/static/";

    @RequestMapping(value = "uploadGameLink", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> uploadGameLink(@RequestParam("QRCode") CommonsMultipartFile QRCode, GameLinkDto gameLinkDto) {
        String fileName = metaService.saveFile(QRCode);
        gameLinkDto.setQRCodeUrl(staticFilePath+fileName);
        metaService.saveConfig(gameLinkDto);
        return WebUtil.result("");
    }
}
