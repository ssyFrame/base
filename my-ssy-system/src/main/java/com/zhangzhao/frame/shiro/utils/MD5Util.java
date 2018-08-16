package com.zhangzhao.frame.shiro.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

/**
 * @author ZhangZhao
 * @date 2018/8/16 22:44
 */
public class MD5Util {
    //pwd为明文密码，salt为盐（可自定义），i加密次数
    public static String toMd5(String pwd,String salt){
        Md5Hash toMd5 = new Md5Hash(pwd,ByteSource.Util.bytes(salt),1);
        return toMd5.toString();
    }
}
