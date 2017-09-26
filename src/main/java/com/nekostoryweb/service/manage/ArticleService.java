package com.nekostoryweb.service.manage;

import com.github.pagehelper.PageInfo;
import com.nekostoryweb.dao.dto.ArticleDto;
import com.nekostoryweb.dao.dto.ImgDto;
import com.nekostoryweb.dao.dto.Page;
import com.nekostoryweb.dao.dto.StrategyDto;
import com.nekostoryweb.dao.po.Article;
import com.nekostoryweb.dao.po.Imgs;
import com.nekostoryweb.dao.po.Strategy;

/**
 * Created by yujingyang on 2017/9/21.
 */
public interface ArticleService {
    void saveArticle(ArticleDto articleDto);

    void updateArticle(ArticleDto articleDto, Integer articleId);

    void updateStrategy(StrategyDto strategyDto, Integer strategyId);

    void updateImg(ImgDto imgDto, Integer imgId);

    void saveStrategy(StrategyDto strategyDto);

    void saveImgs(ImgDto imgDto);

    PageInfo<Imgs> getImgsList(Page page);

    PageInfo<Article> getArticleList(Page page);

    PageInfo<Strategy> getStrategyList(Page page);

    void deleteArticle(Integer articleId);

    void deleteStrategy(Integer strategyId);

    void deleteImgs(Integer imgId);
}
