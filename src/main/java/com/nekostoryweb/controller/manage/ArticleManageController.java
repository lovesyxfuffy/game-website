package com.nekostoryweb.controller.manage;

import com.nekostoryweb.dao.dto.ArticleDto;
import com.nekostoryweb.dao.dto.ImgDto;
import com.nekostoryweb.dao.dto.Page;
import com.nekostoryweb.dao.dto.StrategyDto;
import com.nekostoryweb.dao.mapper.ArticleMapper;
import com.nekostoryweb.dao.mapper.ImgsMapper;
import com.nekostoryweb.dao.mapper.StrategyMapper;
import com.nekostoryweb.dao.po.Article;
import com.nekostoryweb.dao.po.Imgs;
import com.nekostoryweb.dao.po.Strategy;
import com.nekostoryweb.service.manage.ArticleService;
import com.nekostoryweb.service.manage.MetaService;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    StrategyMapper strategyMapper;
    @Autowired
    ImgsMapper imgsMapper;

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
                                                             ArticleDto articleDto,HttpServletRequest request) {

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

    @RequestMapping(value = "updateArticle",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> updateArticle(ArticleDto articleDto, @RequestParam("articleId")Integer articleId){
        articleService.updateArticle(articleDto,articleId);
        return WebUtil.result("");
    }

    @RequestMapping(value = "updateStrategy",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> updateStrategy(StrategyDto strategy, @RequestParam("strategyId")Integer strategyId){
        articleService.updateStrategy(strategy,strategyId);
        return WebUtil.result("");
    }

    @RequestMapping(value = "updateImgs",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> updateImgs(ImgDto imgDto,@RequestParam("imgId")Integer imgId){
        articleService.updateImg(imgDto,imgId);
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

    @RequestMapping(value = "getImgsList",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> getImgsList(Page page){
        return WebUtil.result(articleService.getImgsList(page));
    }

    @RequestMapping(value = "getArticleList",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> getArticleList(Page page){
        return WebUtil.result(articleService.getArticleList(page));
    }

    @RequestMapping(value = "getStrategyList",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> getStrategyList(Page page){
        return WebUtil.result(articleService.getStrategyList(page));
    }

    @RequestMapping(value = "editArticle",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> editArticle(@RequestParam("oper") String oper,@RequestParam("id") String ids){
        String[] idListStr = ids.split(",");
        for(String idStr :idListStr){
            if("del".equals(oper))
                articleService.deleteArticle(Integer.parseInt(idStr));
        }

        return WebUtil.result("");
    }

    @RequestMapping(value = "editStrategy",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> editStrategy(@RequestParam("oper") String oper,@RequestParam("id") String ids){
        String[] idListStr = ids.split(",");
        for(String idStr :idListStr){
            if("del".equals(oper))
                articleService.deleteStrategy(Integer.parseInt(idStr));
        }

        return WebUtil.result("");
    }

    @RequestMapping(value = "editImgs",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> editImgs(@RequestParam("oper") String oper,@RequestParam("id") String ids){
        String[] idListStr = ids.split(",");
        for(String idStr :idListStr){
            if("del".equals(oper))
                articleService.deleteImgs(Integer.parseInt(idStr));
        }
        return WebUtil.result("");
    }


    @RequestMapping(value = "updateArticle/{articleId}",method = RequestMethod.GET)
    public String updateArticle(@PathVariable("articleId") Integer articleId, Model model, HttpServletRequest request){
        Article article = articleMapper.selectByPrimaryKey(articleId);
        model.addAttribute("requestURI","");
        model.addAttribute("article",article);

        return "views/postArticle.ftl";
    }

    @RequestMapping(value = "updateStrategy/{strategyId}",method = RequestMethod.GET)
    public String updateStrategy( Model model, HttpServletRequest request, @PathVariable("strategyId") Integer strategyId){
        Strategy strategy = strategyMapper.selectByPrimaryKey(strategyId);
        model.addAttribute("requestURI","");
        model.addAttribute("strategy",strategy);

        return "views/postStrategy.ftl";
    }

    @RequestMapping(value = "updateImgs/{imgsId}",method = RequestMethod.GET)
    public String updateImgs(Model model, HttpServletRequest request, @PathVariable("imgsId") Integer imgsId){
        Imgs imgs= imgsMapper.selectByPrimaryKey(imgsId);
        model.addAttribute("requestURI","");
        model.addAttribute("imgs",imgs);

        return "views/postImgs.ftl";
    }

}
