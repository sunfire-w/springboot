package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2019/8/1 0001.
 */
@FeignClient(name="PRODUCTSERVICE")
public interface ProductService {
    @RequestMapping(value = "/pengproducer",method = RequestMethod.GET)
    String sayHello();
}
