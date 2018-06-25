package com.zhangzhao.frame.controller;

import com.zhangzhao.frame.common.JSONResult;
import com.zhangzhao.frame.model.SysUser;
import com.zhangzhao.frame.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangZhao
 * @date 2018/6/3 20:22
 */
@RestController
public class TestRestController {

    @Autowired
    private SysUserService sysUserService;
    @RequestMapping(value = "/getAjax")
    @ResponseBody
    public JSONResult errorJson(){
        return JSONResult.ok();
    }

    @RequestMapping(value = "/saveUser")
    @ResponseBody
    public JSONResult addUser(){
        SysUser user = new SysUser();
        user.setId(1);
        user.setAge(10);
        user.setName("123");
        user.setUsername("admin");
        user.setPassword("123456");
        sysUserService.saveUser(user);

        return JSONResult.ok();
    }
}
