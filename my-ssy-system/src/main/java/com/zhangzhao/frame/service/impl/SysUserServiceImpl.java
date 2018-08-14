package com.zhangzhao.frame.service.impl;

import com.zhangzhao.frame.dao.SysUserMapper;
import com.zhangzhao.frame.model.SysUser;
import com.zhangzhao.frame.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        sysUserMapper.insert(sysUser);
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
