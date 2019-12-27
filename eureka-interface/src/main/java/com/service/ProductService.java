package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2019/8/1 0001.
 * 接口调用服务，fallback服务降级处理
 */
@FeignClient(name="PRODUCTSERVICE",fallback = ProductServiceFallback.class)
public interface ProductService {
    @RequestMapping(value="/pengproducer", method = RequestMethod.POST)
    String sayHello();
}


