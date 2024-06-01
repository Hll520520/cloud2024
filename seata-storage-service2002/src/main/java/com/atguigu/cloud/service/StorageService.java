package com.atguigu.cloud.service;

/**
 * @author yexingchen
 * @create 2024-06-01 17:12
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
