package com.nekostoryweb.controller.front;

import com.nekostoryweb.Contants.ArticleType;
import com.nekostoryweb.Contants.ImgsType;
import com.nekostoryweb.Contants.StrategyType;
import com.nekostoryweb.dao.dto.FrontPage;
import com.nekostoryweb.service.front.ArticleService;
import com.nekostoryweb.utils.RequestBodyFilter;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
@RequestMapping("/front")
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/news/getNewsTypeEnum", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getNewsTypeEnum() {
        Map<Integer, String> articleType = ArticleType.getType();
        List<Map<String, Object>> result = new ArrayList<>();
        articleType.forEach((key, value) -> {
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("typeCode", key);
            tmp.put("typeName", value);
            result.add(tmp);
        });
        Map<String,Object> returnResult = new HashMap<>();
        returnResult.put("typeList",result);
        return WebUtil.result(returnResult);
    }

    @RequestMapping(value = "/strategy/getStrategyTypeEnum", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getStrategyEnum() {
        Map<Integer, String> strategyType = StrategyType.getStrategyType();
        List<Map<String, Object>> result = new ArrayList<>();
        strategyType.forEach((key, value) -> {
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("typeCode", key);
            tmp.put("typeName", value);
            result.add(tmp);
        });
        Map<String,Object> returnResult = new HashMap<>();
        returnResult.put("typeList",result);
        return WebUtil.result(returnResult);
    }

    @RequestMapping(value = "/activity/getTypeEnum", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getActivityEnum() {
        Map<Integer, String> articleType = ArticleType.getType();
        List<Map<String, Object>> result = new ArrayList<>();
        articleType.forEach((key, value) -> {
            if ("线下活动".equals(value) || "线上活动".equals(value)) {
                Map<String, Object> tmp = new HashMap<>();
                tmp.put("typeCode", key);
                tmp.put("typeName", value);
                result.add(tmp);
            }
        });
        Map<String,Object> returnResult = new HashMap<>();
        returnResult.put("typeList",result);
        return WebUtil.result(returnResult);
    }

    @RequestMapping(value = "/activity/getContentList", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getActivityContentList(@RequestBody Map<String, Integer> params) {
        Integer typeCode = params.get("typeCode");
        FrontPage frontPage = RequestBodyFilter.filter(params, FrontPage.class);
        return WebUtil.result(articleService.getActivityList(frontPage, typeCode));
    }

    @RequestMapping(value = "/strategy/getContentList", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getStrategyContentList(@RequestBody Map<String, Integer> params) {
        Integer typeCode = params.get("typeCode");
        FrontPage frontPage = RequestBodyFilter.filter(params, FrontPage.class);
        return WebUtil.result(articleService.getStrategyList(frontPage, typeCode));
    }

    @RequestMapping(value = "/news/getContentList", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getNewsContentList(@RequestBody Map<String, Integer> params) {
        Integer typeCode = params.get("typeCode");
        FrontPage frontPage = RequestBodyFilter.filter(params, FrontPage.class);
        return WebUtil.result(articleService.getArticleList(frontPage, typeCode));
    }

    @RequestMapping(value = {"/news/getNewsDetail/{articleId}", "/activity/getActivityDetail/{articleId}", "/article/getArticleDetail/{articleId}"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getNewsDetail(@PathVariable("articleId") Integer articleId) {
        return WebUtil.result(articleService.getArticle(articleId));
    }
    @RequestMapping(value = "/strategy/getStrategyDetail/{strategyId}", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getStrategyDetail(@PathVariable("strategyId") Integer strategyId) {
        return WebUtil.result(articleService.getStrategy(strategyId));
    }

    @RequestMapping(value = "/doujin/getTypeEnum", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getImgsTypeEnum() {
        Map<Integer, String> articleType = ImgsType.getImgsType();
        List<Map<String, Object>> result = new ArrayList<>();
        articleType.forEach((key, value) -> {
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("typeCode", key);
            tmp.put("typeName", value);
            result.add(tmp);
        });
        Map<String,Object> returnResult = new HashMap<>();
        returnResult.put("typeList",result);
        return WebUtil.result(returnResult);
    }

    @RequestMapping(value = "/doujin/getContentList", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getImgsContentList(@RequestBody Map<String, Integer> params) {
        Integer typeCode = params.get("typeCode");
        FrontPage frontPage = RequestBodyFilter.filter(params, FrontPage.class);
        return WebUtil.result(articleService.getImgsContentList(frontPage, typeCode));
    }
}
