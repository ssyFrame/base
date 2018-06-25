package com.zhangzhao.frame.controller;

import com.zhangzhao.frame.common.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZhangZhao
 * @date 2018/5/27 12:07
 */
@Controller
public class TestController {

    @RequestMapping(value = "/")
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/main")
    public String index1(){
        return "main";
    }

    @RequestMapping(value = "/main1")
    public String index2(){
        return "main";
    }

    @RequestMapping(value = "/errorpage")
    public String index3(){
        return "ajaxerror";
    }

    @RequestMapping(value = "/json")
    @ResponseBody
    public String json(){
        return "123";
    }


}
