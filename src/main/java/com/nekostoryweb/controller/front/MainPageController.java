package com.nekostoryweb.controller.front;

import com.nekostoryweb.service.front.MainPageService;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/26.
 */
@RequestMapping("/front/mainPage")
public class MainPageController {
    @Autowired
    MainPageService mainPageService;

    @RequestMapping(value = "/getVideoPage",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> getVideoPage(@RequestBody Map<String,Integer> params){
        Integer typeCode = params.get("typeCode");
        Map<String,Object> result = new HashMap<>();
        result.put("video",mainPageService.getVideoConfig(typeCode));
        return WebUtil.result(result);
    }

}
