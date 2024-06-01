package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @author yexingchen
 * @create 2024-06-01 16:30
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
