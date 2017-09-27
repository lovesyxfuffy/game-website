package com.nekostoryweb.Contants;

import com.nekostoryweb.dao.dto.MainPageDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/27.
 */
public class MainPageType {
    private static Map<Integer,String> mainPageType = new HashMap<>();
    static {


        mainPageType.put(0,"最新");
        mainPageType.put(1,"新闻");
        mainPageType.put(2,"公告");
        mainPageType.put(3,"活动");
        mainPageType.put(4,"攻略");

    }

    public static Map<Integer, String> getMainPageType() {
        return mainPageType;
    }

}
