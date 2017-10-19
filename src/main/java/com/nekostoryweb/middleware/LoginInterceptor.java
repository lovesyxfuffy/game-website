package com.nekostoryweb.middleware;

import com.nekostoryweb.contants.CacheMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by yujingyang on 2017/9/26.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String URI = request.getRequestURI();
        String time = CacheMap.getCacheMap().get("lastLoginTime");
        long now = System.currentTimeMillis();
        long last = 0l;
        if (time != null)
            last = Long.parseLong(time);
        if (now - last > 300000) {
            CacheMap.setCacheMap(new HashMap<>());
            CacheMap.getCacheMap().put("lastLoginTime",String.valueOf(now));//清空缓存
        }
        if (userName != null || URI.equals("/api/system/login") || URI.equals("/api/views/login") || !URI.contains("/api"))
            return true;
        else
            response.sendRedirect("/api/views/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
