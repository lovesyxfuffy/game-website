package com.nekostoryweb.Contants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
public class ArticleType {
    private static Map<Integer,String> articleType = new HashMap<>();
    static {
        articleType.put(0,"最新");
        articleType.put(1,"新闻");
        articleType.put(2,"公告");
        articleType.put(4,"线上活动");
        articleType.put(8,"线下活动");
    }

    public static Map<Integer, String> getType(){
        return articleType;
    }
}
