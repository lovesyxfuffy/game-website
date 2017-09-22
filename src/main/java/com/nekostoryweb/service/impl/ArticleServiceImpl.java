package com.nekostoryweb.service.impl;

import com.nekostoryweb.dao.dto.ArticleDto;
import com.nekostoryweb.dao.dto.ImgDto;
import com.nekostoryweb.dao.dto.StrategyDto;
import com.nekostoryweb.dao.mapper.ArticleMapper;
import com.nekostoryweb.dao.mapper.ImgsMapper;
import com.nekostoryweb.dao.mapper.StrategyMapper;
import com.nekostoryweb.dao.po.Article;
import com.nekostoryweb.dao.po.Imgs;
import com.nekostoryweb.dao.po.Strategy;
import com.nekostoryweb.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        articleMapper.insert(article);
    }

    @Override
    public void saveStrategy(StrategyDto strategyDto) {
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyDto, strategy);
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
}
