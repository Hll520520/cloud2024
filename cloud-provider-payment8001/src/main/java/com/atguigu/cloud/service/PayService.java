package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * @author yexingchen
 * @create 2024-05-09 18:43
 */
public interface PayService {
    int add(Pay pay);
    int delete(Integer id);
    int update(Pay pay);

   public Pay getById(Integer id);
   public List<Pay> getAll();
}
