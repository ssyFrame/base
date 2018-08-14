package com.zhangzhao.frame.dao;

import com.zhangzhao.frame.utils.MyMapper;
import com.zhangzhao.frame.model.SysUser;

import java.util.List;

public interface SysUserMapper extends MyMapper<SysUser> {

    List<SysUser> findByUsername(String username);
}