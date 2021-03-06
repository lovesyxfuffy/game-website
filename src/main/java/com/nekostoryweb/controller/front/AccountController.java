package com.nekostoryweb.controller.front;

import com.nekostoryweb.contants.CacheMap;
import com.nekostoryweb.dao.po.OrderInfo;
import com.nekostoryweb.service.front.AccountService;
import com.nekostoryweb.utils.RequestBodyFilter;
import com.nekostoryweb.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyang on 2017/9/27.
 */
@RequestMapping("/front/account")
@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/getCheckCode", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getCheckCode(HttpServletRequest request, @RequestBody Map<String, String> params) {
        String telephone = params.get("telephone");
        CacheMap.getCacheMap().put(telephone,accountService.sendVerifyCode(telephone));

        return WebUtil.result("");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> params, HttpServletRequest request) {
        OrderInfo orderInfo = RequestBodyFilter.filter(params, OrderInfo.class);
        orderInfo.setAddTime(new Date());
        String checkCode = CacheMap.getCacheMap().get(orderInfo.getTelephone());
        Map<String, Object> result = new HashMap<>();
        CacheMap.getCacheMap().remove(orderInfo.getTelephone());//用后作废
        if (checkCode != null && checkCode.equals(params.get("verifyCode"))) {
            int code = accountService.insertOrderInfo(params.get("telephone"), params.get("phoneType"));
            result.put("resultCode", code);
            switch (code){
                case 1:
                    result.put("resultMsg", "预约成功");
                    break;
                case 2 :
                    result.put("resultMsg", "已经预约过");
            }
            return WebUtil.result(result);
        }
        result.put("resultCode", 0);
        result.put("resultMsg", "预约失败");
        return WebUtil.result(result);
    }

}
