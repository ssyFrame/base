package com.zhangzhao.frame.service.impl;

import com.zhangzhao.frame.dao.SysUserMapper;
import com.zhangzhao.frame.model.SysUser;
import com.zhangzhao.frame.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhangZhao
 * @date 2018/6/7 00:08
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public void saveUser(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }
}
