package com.zhangzhao.frame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 默认启动方式(包含自带容器Tomcat)
 */
@SpringBootApplication
//@EnableRedisHttpSession
//@MapperScan(FinalConfig.MAPPER_SCAN_BASE_PACKAGE)
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class,args);
    }
}
