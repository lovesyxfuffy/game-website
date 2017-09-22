package com.nekostoryweb.controller;

import com.nekostoryweb.dao.dto.ArticleDto;
import com.nekostoryweb.dao.dto.ImgDto;
import com.nekostoryweb.dao.dto.StrategyDto;
import com.nekostoryweb.service.ArticleService;
import com.nekostoryweb.service.MetaService;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Map;

/**
 * Created by yujingyang on 2017/9/21.
 */
@Controller
@RequestMapping("/api/article")
public class ArticleManageController {

    @Autowired
    MetaService metaService;
    @Autowired
    ArticleService articleService;

    private final static String staticFilePath = "/static/";

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file) {
        String fileName = metaService.saveFile(file);
        return staticFilePath + fileName;
    }

    @RequestMapping(value = "uploadArticle", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> uploadArticle(@RequestParam("imgFile") CommonsMultipartFile imgFile,
                                                             @RequestParam("type") Integer[] typeCodes,
                                                             ArticleDto articleDto) {
        int type = 0;
        for (int row : typeCodes) {
            type += row;
        }
        articleDto.setType(type);
        String fileName = metaService.saveFile(imgFile);
        articleDto.setImgUrl(staticFilePath + fileName);
        articleService.saveArticle(articleDto);
        return WebUtil.result("");
    }

    @RequestMapping(value = "uploadStrategy",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> uploadStrategy(@RequestParam("imgFile") CommonsMultipartFile imgFile,
                                                             @RequestParam("type") Integer[] typeCodes,
                                                             StrategyDto strategyDto){
        int type = 0;
        for (int row : typeCodes) {
            type += row;
        }
        strategyDto.setType(type);
        String fileName = metaService.saveFile(imgFile);
        strategyDto.setImgUrl(staticFilePath + fileName);
        articleService.saveStrategy(strategyDto);
        return WebUtil.result("");
    }

    @RequestMapping(value = "uploadImgs",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> uploadImgs(@RequestParam("imgFile") CommonsMultipartFile imgFile,
                                                         @RequestParam("type") Integer[] typeCodes,
                                                         ImgDto imgDto){
        int type = 0;
        for (int row : typeCodes) {
            type += row;
        }
        imgDto.setType(type);
        String fileName = metaService.saveFile(imgFile);
        imgDto.setImgUrl(staticFilePath + fileName);
        articleService.saveImgs(imgDto);
        return WebUtil.result("");
    }
}
