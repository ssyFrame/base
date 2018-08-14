package com.zhangzhao;

import com.zhangzhao.frame.config.FinalConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 默认启动方式(包含自带容器Tomcat)
 */
@SpringBootApplication
//@EnableRedisHttpSession
@ComponentScan(value = {"com.zhangzhao.frame","com.zhangzhao.shiro.utils"})
@MapperScan(FinalConfig.MAPPER_SCAN_BASE_PACKAGE)
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class,args);
    }
}
