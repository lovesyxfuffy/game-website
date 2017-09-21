package com.nekostoryweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/20.
 */
@Controller
@RequestMapping("/api/views")
public class ViewController {
    @RequestMapping(value = "/gameLink",method = RequestMethod.GET)
    public String getView(Model model , HttpServletRequest request){
        model.addAttribute("requestURI",request.getRequestURI());

        return "views/gameLink.ftl";
    }
}
