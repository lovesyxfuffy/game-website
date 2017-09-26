package com.nekostoryweb.controller.manage;

import com.nekostoryweb.service.manage.SystemService;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(String userName, String password,HttpServletRequest request ,HttpServletResponse response) {
        int result = systemService.login(userName, password);
        if (result > 0){
            HttpSession session = request.getSession();
            session.setAttribute("userName",userName);
            return WebUtil.result("");
        }
        else
            return WebUtil.error("账号密码不正确");
    }

    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> logout(HttpServletRequest request){
        request.getSession().setAttribute("userName",null);
        return WebUtil.result("");
    }
}

