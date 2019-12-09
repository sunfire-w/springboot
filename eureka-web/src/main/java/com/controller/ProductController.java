package com.controller;

import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/8/2 0002.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/pengproducer",method = RequestMethod.GET)
    public String sayHello(){
        return productService.sayHello();
    }
}
