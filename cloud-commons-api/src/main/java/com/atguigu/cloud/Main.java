package com.atguigu.cloud;

import java.time.ZonedDateTime;

/**
 * @author yexingchen
 * @create 2024-05-22 23:48
 */
public class Main {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}
