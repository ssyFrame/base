/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.zhangzhao.frame;

//import org.mybatis.spring.annotation.MapperScan;
import com.zhangzhao.frame.config.FinalConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * Web启动方式(不包含容器Tomcat)
 */
@SpringBootApplication
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60000)
@MapperScan(FinalConfig.MAPPER_SCAN_BASE_PACKAGE)
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }


}