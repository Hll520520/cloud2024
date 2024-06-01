package com.atguigu.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author yexingchen
 * @create 2024-06-01 17:53
 */
public interface AccountService {
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
