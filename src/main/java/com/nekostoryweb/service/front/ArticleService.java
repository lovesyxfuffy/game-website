package com.nekostoryweb.service.front;

import com.nekostoryweb.dao.dto.FrontPage;

import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
public interface ArticleService {
    Map<String, Object> getArticleList(FrontPage frontPage, Integer typeCode);

    Map<String, String> getArticle(Integer articleId);

    Map<String, Object> getActivityList(FrontPage frontPage, Integer typeCode);

}
