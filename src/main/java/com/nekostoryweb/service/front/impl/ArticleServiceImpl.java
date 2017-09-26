package com.nekostoryweb.service.front.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nekostoryweb.dao.dto.FrontPage;
import com.nekostoryweb.dao.mapper.ArticleMapper;
import com.nekostoryweb.dao.po.Article;
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

    @Override
    public Map<String, Object> getArticleList(FrontPage frontPage, Integer typeCode) {
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(frontPage.getPageNumber(), frontPage.getPageSize());
        List<Article> result = articleMapper.selectByStatus(typeCode);
        PageInfo<Article> pageInfo = new PageInfo<>(result);
        List<Map<String, Object>> returnList = new ArrayList<>();
        result.forEach((row)->{
            Map<String,Object> tmp = new HashMap<>();
            tmp.put("id",row.getId());
            tmp.put("title",row.getTitle());
            tmp.put("subContent",row.getContent().substring(0,30));
            tmp.put("dateTime",row.getAddTime());
            returnList.add(tmp);
        });
        Map<String, Object> returnResult = new HashMap<>();
        returnResult.put("contentList", returnList);
        returnResult.put("page",PageFilter.filter(pageInfo));
        return returnResult;
    }

    @Override
    public Map<String, String> getArticle(Integer articleId){
        Article article = articleMapper.selectByPrimaryKey(articleId);
        Map<String,String> result = new HashMap<>();
        result.put("title",article.getTitle());
        result.put("writer",article.getWriter());
        result.put("dateTime",article.getAddTime());
        result.put("content",article.getContent());
        return result;
    }
    @Override
    public Map<String, Object> getActivityList(FrontPage frontPage, Integer typeCode){
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(frontPage.getPageNumber(), frontPage.getPageSize());
        List<Article> result = articleMapper.selectByStatus(typeCode);
        PageInfo<Article> pageInfo = new PageInfo<>(result);
        List<Map<String, Object>> returnList = new ArrayList<>();
        result.forEach((row)->{
            Map<String,Object> tmp = new HashMap<>();
            tmp.put("id",row.getId());
            tmp.put("imgUrl",row.getImgUrl());
            returnList.add(tmp);
        });
        Map<String, Object> returnResult = new HashMap<>();
        returnResult.put("contentList", returnList);
        returnResult.put("page",PageFilter.filter(pageInfo));
        return returnResult;
    }
}
