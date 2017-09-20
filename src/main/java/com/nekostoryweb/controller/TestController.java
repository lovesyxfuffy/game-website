package com.nekostoryweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by yujingyang on 2017/9/18.
 */
@Controller
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value = "/helloWorld",method = RequestMethod.GET)
    public String helloWorld(Model model, HttpServletRequest request){
        model.addAttribute("word","helloWorld");
        model.addAttribute("requestURI",request.getRequestURI());
        return "model.ftl";
    }
}
