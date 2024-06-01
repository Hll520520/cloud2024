package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yexingchen
 * @create 2024-05-12 15:49
 */
@RestController
public class OrderController {
    //public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }
    @GetMapping("/consumer/pay/del/{id}")
    public ResultData delPayInfo(@PathVariable("id")Integer id){
        ResponseEntity<ResultData> responseEntity = restTemplate.exchange(
                PaymentSrv_URL + "/pay/del/" + id,
                HttpMethod.DELETE,
                null,
                ResultData.class);
        return responseEntity.getBody();
    }
    @GetMapping("/consumer/pay/update")
    public ResultData updateOrder(PayDTO payDTO){
        ResponseEntity<ResultData> responseEntity = restTemplate.exchange(
                PaymentSrv_URL + "/pay/update",
                HttpMethod.PUT,
                new HttpEntity<>(payDTO),
                ResultData.class);
        return responseEntity.getBody();

    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id, ResultData.class, id);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }
}

