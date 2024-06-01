package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author yexingchen
 * @create 2024-05-20 10:14
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/fegin/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }
    @GetMapping("/fegin/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable ("id")Integer id){
        System.out.println("----------支付微服务远程调用,按照订单id查询订单流水---------");
        ResultData resultData = null;
        try {
            System.out.println("-----调用开始:" + DateUtil.now());
            resultData = payFeignApi.getPayinfo(id);
        } catch (Exception e) {
            System.out.println("-----调用结束:" + DateUtil.now());
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return resultData;
    }

    @GetMapping("/fegin/pay/myLB")
    public String mylb(){
        return payFeignApi.mylb();
    }
}
