package com.nekostoryweb.controller;

import com.nekostoryweb.service.SystemService;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/18.
 */
@Controller
@RequestMapping("/api/system")
public class SystemController {

    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/getMenu", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getMenu(@RequestParam("requestURI") String requestURI) {
        return WebUtil.result(systemService.getMenu(requestURI));
    }
}
