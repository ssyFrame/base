package com.zhangzhao.frame.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangzhao.frame.model.SysUser;
import com.zhangzhao.frame.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 */
@RestController
@CrossOrigin
public class LoginController {

    @Resource
    private SysUserService sysUserService;
    /**
     * 登录方法
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxLogin(SysUser userInfo) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    /**
     * 注册接口
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/registor", method = RequestMethod.POST)
    @ResponseBody
    public String registor(SysUser sysUser){
        JSONObject jsonObject = new JSONObject();
        try{
            sysUserService.saveUser(sysUser);
            jsonObject.put("msg", "注册成功");
        } catch (Exception e) {
            jsonObject.put("msg", "注册失败");
        }
        return jsonObject.toString();
    }

    /**
     * 测试数据
     * @param
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        JSONObject jsonObject = new JSONObject();
        try{
            sysUserService.findByUsername("admin");
            jsonObject.put("msg", "测试成功");
        } catch (Exception e) {
            jsonObject.put("msg", "测试失败");
        }
        return jsonObject.toString();
    }
}
