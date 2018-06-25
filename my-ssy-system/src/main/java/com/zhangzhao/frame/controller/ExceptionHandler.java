package com.zhangzhao.frame.controller;

import com.zhangzhao.frame.common.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhangZhao
 * @date 2018/6/2 16:24
 */
@RestControllerAdvice
public class ExceptionHandler {
    private static final String error_view = "error";

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e) throws Exception{
        e.printStackTrace();
        if(isAjax(request)){
            JSONResult jr = JSONResult.errorException(e.getMessage());
            return jr;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception",e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(error_view);
            return mav;
        }

    }

    public static boolean isAjax(HttpServletRequest httpServletRequest){
        return (httpServletRequest.getHeader("X-Requested-With") !=null
                && "XMLHttpRequest".equals(httpServletRequest.getHeader("X-Requested-With").toString()));

    }
}
