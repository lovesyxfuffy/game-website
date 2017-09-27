package com.nekostoryweb.service.front.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nekostoryweb.dao.dto.FrontPage;
import com.nekostoryweb.dao.mapper.ArticleMapper;
import com.nekostoryweb.dao.mapper.ImgsMapper;
import com.nekostoryweb.dao.mapper.StrategyMapper;
import com.nekostoryweb.dao.po.*;
import com.nekostoryweb.service.front.ArticleService;
import com.nekostoryweb.utils.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
@Service("FrontArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    StrategyMapper strategyMapper;
    @Autowired
    ImgsMapper imgsMapper;

    @Override
    public Map<String, Object> getArticleList(FrontPage frontPage, Integer typeCode) {
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(frontPage.getPageNumber(), frontPage.getPageSize());
        List<Article> result;
        if (typeCode != 0)
            result = articleMapper.selectByStatus(typeCode);
        else {
            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria().andIsUpToDateEqualTo((byte) 1);
            result = articleMapper.selectByExample(articleExample);
        }

        PageInfo<Article> pageInfo = new PageInfo<>(result);
        List<Map<String, Object>> returnList = new ArrayList<>();
        result.forEach((row) -> {
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("id", row.getId());
            tmp.put("title", row.getTitle());
            tmp.put("subContent", row.getContent().substring(0, 30));
            tmp.put("dateTime", row.getAddTime());
            returnList.add(tmp);
        });
        Map<String, Object> returnResult = new HashMap<>();
        returnResult.put("contentList", returnList);
        returnResult.put("page", PageFilter.filter(pageInfo));
        return returnResult;
    }

    @Override
    public List<String> getImgs() {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andIsUpToDateEqualTo((byte) 1);
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(1, 5);
        List<Article> result = articleMapper.selectByExample(articleExample);
        PageInfo<Article> pageInfo = new PageInfo<>(result);
        List<String> returnList = new ArrayList<>();
        result.forEach((row) -> returnList.add(row.getImgUrl()));
        return returnList;
    }

    @Override
    public Map<String, Object> getStrategyList(FrontPage frontPage, Integer typeCode) {
        com.github.pagehelper.Page<Strategy> page1 = PageHelper.startPage(frontPage.getPageNumber(), frontPage.getPageSize());
        List<Strategy> result;
        if (typeCode != -1)
            result = strategyMapper.selectByStatus(typeCode);
        else
            result = strategyMapper.selectByExample(new StrategyExample());

        PageInfo<Strategy> pageInfo = new PageInfo<>(result);
        List<Map<String, Object>> returnList = new ArrayList<>();
        result.forEach((row) -> {
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("id", row.getId());
            tmp.put("title", row.getTitle());
            tmp.put("subContent", row.getContent().substring(0, 30));
            tmp.put("dateTime", row.getAddTime());
            returnList.add(tmp);
        });
        Map<String, Object> returnResult = new HashMap<>();
        returnResult.put("contentList", returnList);
        returnResult.put("page", PageFilter.filter(pageInfo));
        return returnResult;
    }

    @Override
    public Map<String, String> getArticle(Integer articleId) {
        Article article = articleMapper.selectByPrimaryKey(articleId);
        Map<String, String> result = new HashMap<>();
        result.put("title", article.getTitle());
        result.put("writer", article.getWriter());
        result.put("dateTime", article.getAddTime());
        result.put("content", article.getContent());
        return result;
    }

    @Override
    public Map<String, Object> getActivityList(FrontPage frontPage, Integer typeCode) {
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(frontPage.getPageNumber(), frontPage.getPageSize());
        List<Article> result = articleMapper.selectByStatus(typeCode);
        PageInfo<Article> pageInfo = new PageInfo<>(result);
        List<Map<String, Object>> returnList = new ArrayList<>();
        result.forEach((row) -> {
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("id", row.getId());
            tmp.put("imgUrl", row.getImgUrl());
            returnList.add(tmp);
        });
        Map<String, Object> returnResult = new HashMap<>();
        returnResult.put("contentList", returnList);
        returnResult.put("page", PageFilter.filter(pageInfo));
        return returnResult;
    }

    @Override
    public Map<String, Object> getImgsContentList(FrontPage frontPage, Integer typeCode) {
        List<Imgs> result;
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(frontPage.getPageNumber(), frontPage.getPageSize());
        if (typeCode == 0) {
            ImgsExample imgsExample = new ImgsExample();
            imgsExample.createCriteria().andIsSelectEqualTo((byte) 1);
            result = imgsMapper.selectByExample(imgsExample);
        } else {
            result = imgsMapper.selectByType(typeCode);
        }
        List<Map<String, Object>> returnList = new ArrayList<>();
        result.forEach((row) -> {
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("isVideo", row.getIsVideo() == (byte)1);
            tmp.put("imgUrl", row.getImgUrl());
            tmp.put("videoUrl", row.getVideoUrl());

            returnList.add(tmp);
        });
        PageInfo<Imgs> pageInfo = new PageInfo<>(result);
        Map<String, Object> returnResult = new HashMap<>();
        returnResult.put("contentList", returnList);
        returnResult.put("page", PageFilter.filter(pageInfo));
        return returnResult;
    }
}
