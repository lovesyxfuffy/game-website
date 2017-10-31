package com.nekostoryweb.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nekostoryweb.dao.dto.ArticleDto;
import com.nekostoryweb.dao.dto.ImgDto;
import com.nekostoryweb.dao.dto.Page;
import com.nekostoryweb.dao.dto.StrategyDto;
import com.nekostoryweb.dao.mapper.ArticleMapper;
import com.nekostoryweb.dao.mapper.ImgsMapper;
import com.nekostoryweb.dao.mapper.StrategyMapper;
import com.nekostoryweb.dao.po.*;
import com.nekostoryweb.service.manage.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yujingyang on 2017/9/21.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    StrategyMapper strategyMapper;
    @Autowired
    ImgsMapper imgsMapper;

    @Override
    public void saveArticle(ArticleDto articleDto) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        article.setContent(article.getContent().replace("&lt;embed","<embed").replace("&gt;&lt;/embed&gt;","></embed>").replace("&lt;video","<video").replace("&gt;&lt;/video&gt;","></video>"));
        articleMapper.insert(article);
    }

    @Override
    public void updateArticle(ArticleDto articleDto, Integer articleId){
        Article article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        article.setId(articleId);
        article.setContent(article.getContent().replace("&lt;embed","<embed").replace("&gt;&lt;/embed&gt;","></embed>").replace("&lt;video","<video").replace("&gt;&lt;/video&gt;","></video>")
                .replace("&lt;video","<video").replace("&gt;&lt;/video&gt;","></video>"));

        articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public void updateStrategy(StrategyDto strategyDto, Integer strategyId){
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyDto, strategy);
        strategy.setId(strategyId);
        strategy.setContent(strategy.getContent().replace("&lt;embed","<embed").replace("&gt;&lt;/embed&gt;","></embed>").replace("&lt;video","<video").replace("&gt;&lt;/video&gt;","></video>"));
        strategyMapper.updateByPrimaryKeySelective(strategy);
    }

    @Override
    public void updateImg(ImgDto imgDto, Integer imgId){
        Imgs imgs = new Imgs();
        if (imgDto.getVideoUrl() != null && !imgDto.getVideoUrl().equals(""))
            imgDto.setIsVideo((byte) 1);
        else
            imgDto.setIsVideo((byte) 0);
        BeanUtils.copyProperties(imgDto, imgs);
        imgs.setId(imgId);
        imgsMapper.updateByPrimaryKeySelective(imgs);
    }

    @Override
    public void saveStrategy(StrategyDto strategyDto) {
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyDto, strategy);
        strategy.setContent(strategy.getContent().replace("&lt;embed","<embed").replace("&gt;&lt;/embed&gt;","></embed>").replace("&lt;video","<video").replace("&gt;&lt;/video&gt;","></video>"));

        strategyMapper.insert(strategy);
    }

    @Override
    public void saveImgs(ImgDto imgDto) {
        Imgs imgs = new Imgs();
        if (imgDto.getVideoUrl() != null && !imgDto.getVideoUrl().equals(""))
            imgDto.setIsVideo((byte) 1);
        else
            imgDto.setIsVideo((byte) 0);
        BeanUtils.copyProperties(imgDto, imgs);
        imgsMapper.insert(imgs);
    }

    @Override
    public PageInfo<Imgs> getImgsList(Page page){
        ImgsExample imgsExample = new ImgsExample();
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(page.getPage(),page.getRows());
        List<Imgs> result = imgsMapper.selectByExample(imgsExample);
        return new PageInfo<>(result);

    }

    @Override
    public PageInfo<Article> getArticleList(Page page){
        ArticleExample articleExample = new ArticleExample();
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(page.getPage(),page.getRows());
        List<Article> result = articleMapper.selectByExample(articleExample);
        return new PageInfo<>(result);
    }

    @Override
    public PageInfo<Strategy> getStrategyList(Page page){
        StrategyExample strategyExample = new StrategyExample();
        com.github.pagehelper.Page<Article> page1 = PageHelper.startPage(page.getPage(),page.getRows());
        List<Strategy> result = strategyMapper.selectByExample(strategyExample);
        return new PageInfo<>(result);

    }

    @Override
    public void deleteArticle(Integer articleId){
        articleMapper.deleteByPrimaryKey(articleId);
    }

    @Override
    public void deleteStrategy(Integer strategyId){
        strategyMapper.deleteByPrimaryKey(strategyId);
    }

    @Override
    public void deleteImgs(Integer imgId){
        imgsMapper.deleteByPrimaryKey(imgId);
    }
}
