package com.nekostoryweb.service.front;

import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
public interface MainPageService {
    String getVideoConfig(Integer typeCode);


    Map<String, Object> getConfigs();
}
