package com.derek.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    //在一个请求进入Controller层方法执行前执行这个方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("接受到请求..." + request.getRequestURL().toString() + "," + request.getLocalAddr());
        long preHandleTime = System.currentTimeMillis();
        request.setAttribute("preHandleTime",preHandleTime);
        return true;
    }

    //Controller执行完毕后，返回之前，可以对request和reponse进行处理
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("处理器处理完毕.." + request.getRequestURL().toString() + "," +request.getLocalAddr());
        long postHandleTime  = System.currentTimeMillis();
        long preHandleTime = Long.valueOf(String.valueOf(request.getAttribute("preHandleTime")));
        long costTime = postHandleTime - preHandleTime;
        logger.info("耗时："+costTime + "ms" );

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("进入 afterCompletion 方法..." + request.getRequestURL().toString() + "," + request.getLocalAddr());
    }
}

