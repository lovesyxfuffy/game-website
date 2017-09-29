package com.nekostoryweb.controller.manage;

import com.nekostoryweb.dao.dto.AboutUsDto;
import com.nekostoryweb.dao.dto.GameLinkDto;
import com.nekostoryweb.dao.dto.OfficialInfoDto;
import com.nekostoryweb.service.manage.MetaService;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Map;

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
        if (fileName != null)
            gameLinkDto.setQRCodeUrl(staticFilePath + fileName);
        metaService.saveConfig(gameLinkDto,"sidebar");
        return WebUtil.result("");
    }

    @RequestMapping(value = "uploadOfficialInfo",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> uploadOfficialInfo(@RequestParam("wechatFile")CommonsMultipartFile wechatFile,
                                                                 @RequestParam("weiboFile")CommonsMultipartFile weiboFile,
                                                                 OfficialInfoDto officialInfoDto){
        officialInfoDto.setWechatOfficialUrl(staticFilePath+metaService.saveFile(wechatFile));
        officialInfoDto.setWeiboOfficialUrl(staticFilePath+metaService.saveFile(weiboFile));
        metaService.saveConfig(officialInfoDto,"officialInfo");
        return WebUtil.result("");
    }

    @RequestMapping(value = "uploadAboutUs",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> uploadAboutUs(AboutUsDto aboutUsDto){
        metaService.saveConfig(aboutUsDto,"aboutUs");
        return WebUtil.result("");
    }
}
