package com.nekostoryweb.controller.front;

import com.nekostoryweb.contants.MainPageType;
import com.nekostoryweb.dao.dto.FrontPage;
import com.nekostoryweb.dao.mapper.StrategyMapper;
import com.nekostoryweb.service.front.AccountService;
import com.nekostoryweb.service.front.ArticleService;
import com.nekostoryweb.service.front.MainPageService;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
@RequestMapping("/front/mainPage")
@Controller
public class MainPageController {
    @Autowired
    MainPageService mainPageService;
    @Autowired
    ArticleService articleService;
    @Autowired
    StrategyMapper strategymapper;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/getVideoPage", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getVideoPage(@RequestBody Map<String, Integer> params) {
        Integer typeCode = params.get("typeCode");
        Map<String, Object> result = new HashMap<>();
        result.put("videoUrl", mainPageService.getVideoConfig(typeCode));
        return WebUtil.result(result);
    }

    @RequestMapping(value = {"/getFooterContent", "/getDownLoads"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getConfigs() {
        return WebUtil.result(mainPageService.getConfigs());
    }

    @RequestMapping(value = "/enum/getTypeEnum", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getTypeEnum() {
        Map<Integer, String> articleType = MainPageType.getMainPageType();
        List<Map<String, Object>> result = new ArrayList<>();
        articleType.forEach((key, value) -> {
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("typeCode", key);
            tmp.put("typeName", value);
            if (key.equals(4))
                tmp.put("typeLink", "/strategyDetail/");
            else
                tmp.put("typeLink", "/newsDetail/");

            result.add(tmp);
        });
        Map<String, Object> returnResult = new HashMap<>();
        returnResult.put("typeList", result);
        return WebUtil.result(returnResult);
    }

    @RequestMapping(value = "/getTypeList/{typeCode}", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getTypeList(@PathVariable("typeCode") Integer typeCode) {
        Object result = null;
        switch (typeCode) {
            case 0: {
                FrontPage frontPage = new FrontPage();
                frontPage.setPageSize(5);
                frontPage.setPageNo(1);
                result = articleService.getArticleList(frontPage, 0);
                break;
            }
            case 1: {
                FrontPage frontPage = new FrontPage();
                frontPage.setPageSize(5);
                frontPage.setPageNo(1);
                result = articleService.getArticleList(frontPage, 1);
                break;
            }
            case 2: {
                FrontPage frontPage = new FrontPage();
                frontPage.setPageSize(5);
                frontPage.setPageNo(1);
                result = articleService.getArticleList(frontPage, 2);
                break;
            }
            case 3: {
                FrontPage frontPage = new FrontPage();
                frontPage.setPageSize(5);
                frontPage.setPageNo(1);
                List<Map<String, Object>> tmp = (List<Map<String, Object>>) articleService.getArticleList(frontPage, 4).get("contentList");
                List<Map<String, Object>> tmp2 = (List<Map<String, Object>>) articleService.getArticleList(frontPage, 8).get("contentList");
                Map<String, Object> t = new HashMap<String, Object>();
                tmp.addAll(tmp2);
                t.put("contentList", tmp);
                result = t;
                break;
            }
            case 4: {
                FrontPage frontPage = new FrontPage();
                frontPage.setPageSize(5);
                frontPage.setPageNo(1);
                result = articleService.getStrategyList(frontPage, -1);
                break;
            }

        }
        return WebUtil.result(result);
    }

    @RequestMapping(value = "getImgs", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getImgs() {
        return WebUtil.result(articleService.getImgs());
    }

    @RequestMapping(value = "/getOrderedAmount", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getOrderedAmount() {
        Map<String, Integer> result = new HashMap<>();
        result.put("amount", accountService.getOrderCount());
        return WebUtil.result(result);
    }

}
