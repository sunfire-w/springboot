package com.controller;

import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2019/8/7 0007.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value="/pengproducer", method = RequestMethod.GET)
    public String sayHello(HttpServletRequest request) throws Exception{
        return productService.sayHello();
    }
}
