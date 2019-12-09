package com.hotel.controller;

import com.hotel.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/8/21 0021.
         */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value="/User/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public User findUserById(@PathVariable(value="id") Long id){
        return this.restTemplate.getForObject("http://localhost:8000/"+id,User.class);
    }
}
