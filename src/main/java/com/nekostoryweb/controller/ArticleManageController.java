package com.nekostoryweb.controller;

import com.nekostoryweb.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by yujingyang on 2017/9/21.
 */
@Controller
@RequestMapping("/api/article")
public class ArticleManageController {

    @Autowired
    MetaService metaService;
    private final static String staticFilePath = "/static/";

    @RequestMapping(value = "fileUpload",method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file){
        String fileName = metaService.saveFile(file);
        return staticFilePath + fileName;
    }
}
