package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yexingchen
 * @create 2024-05-22 18:37
 */
@SpringBootApplication
@EnableDiscoveryClient//服务注册和发现
public class Main9527 {
    public static void main(String[] args) {
        SpringApplication.run(Main9527.class, args);
    }
}
