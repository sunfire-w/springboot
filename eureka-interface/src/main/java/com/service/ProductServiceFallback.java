package com.service;

import org.springframework.stereotype.Component;

/**
 * 服务降级处理，方法签名必须一致
 */
@Component
public class ProductServiceFallback implements ProductService {
    @Override
    public String sayHello() {
        return "sayHelloCallBack hello world";
    }
}
