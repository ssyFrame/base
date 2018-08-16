package com.zhangzhao.frame.service.impl;

import com.zhangzhao.frame.dao.SysUserMapper;
import com.zhangzhao.frame.model.SysUser;
import com.zhangzhao.frame.service.SysUserService;
import com.zhangzhao.frame.shiro.utils.MD5Util;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ZhangZhao
 * @date 2018/6/7 00:08
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void saveUser(SysUser sysUser) {
        sysUser.setCreateDate(DateUtil.formatAsDatetime(new Date()));
        sysUser.setUpdateDate(DateUtil.formatAsDatetime(new Date()));
        sysUser.setCreateUser("admin");
        sysUser.setUpdateUser("admin");
//        sysUser.setPassword(MD5Util.toMd5(sysUser.getPassword(),sysUser.getUsername()));
        ByteSource salt = ByteSource.Util.bytes(sysUser.getUsername());
        String newPs = new SimpleHash("MD5", sysUser.getPassword(), salt, 2).toHex();
        sysUser.setPassword(newPs);
        sysUser.setState(0);
        sysUserMapper.insertUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        List<SysUser> userList = sysUserMapper.findByUsername(username);
        if(userList!=null && userList.size()==1){
            return userList.get(0);
        }else{
            return new SysUser();
        }
    }
}
