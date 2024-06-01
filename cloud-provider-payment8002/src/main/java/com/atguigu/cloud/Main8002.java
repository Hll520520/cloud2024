package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yexingchen
 * @create 2024-05-16 10:19
 */
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient//服务注册与发现
@RefreshScope // 动态刷新
public class Main8002 {
    public static void main(String[] args)
    {
        SpringApplication.run(Main8002.class,args);
    }
}
