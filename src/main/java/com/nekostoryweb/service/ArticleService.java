package com.nekostoryweb.service;

import com.nekostoryweb.dao.dto.ArticleDto;
import com.nekostoryweb.dao.dto.ImgDto;
import com.nekostoryweb.dao.dto.StrategyDto;

/**
 * Created by yujingyang on 2017/9/21.
 */
public interface ArticleService {
    void saveArticle(ArticleDto articleDto);

    void saveStrategy(StrategyDto strategyDto);

    void saveImgs(ImgDto imgDto);
}
