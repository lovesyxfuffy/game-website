package com.nekostoryweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by yujingyang on 2017/9/18.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/api/helloWorld",method = RequestMethod.GET)
    public String helloWorld(Model model){
        model.addAttribute("word","helloWorld");
        return "helloWorld.ftl";
    }
}
