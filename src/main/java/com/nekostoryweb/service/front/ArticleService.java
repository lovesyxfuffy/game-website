package com.nekostoryweb.service.front;

import com.nekostoryweb.dao.dto.FrontPage;

import java.util.List;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
public interface ArticleService {
    Map<String, Object> getArticleList(FrontPage frontPage, Integer typeCode);


    List<String> getImgs();

    Map<String, Object> getStrategyList(FrontPage frontPage, Integer typeCode);

    Map<String, String> getArticle(Integer articleId);

    Map<String, String> getStrategy(Integer strategyId);

    Map<String, Object> getActivityList(FrontPage frontPage, Integer typeCode);

    Map<String, Object> getImgsContentList(FrontPage frontPage, Integer typeCode);
}
