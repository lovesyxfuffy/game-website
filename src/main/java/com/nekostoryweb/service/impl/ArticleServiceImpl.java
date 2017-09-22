package com.nekostoryweb.service.impl;

import com.nekostoryweb.dao.dto.ArticleDto;
import com.nekostoryweb.dao.mapper.ArticleMapper;
import com.nekostoryweb.dao.po.Article;
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

    @Override
    public void saveArticle(ArticleDto articleDto) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        articleMapper.insert(article);
    }
}
