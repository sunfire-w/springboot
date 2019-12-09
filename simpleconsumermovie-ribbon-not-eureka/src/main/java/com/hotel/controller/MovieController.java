package com.hotel.controller;

import com.hotel.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/8/21 0021.
         */
@RestController
public class MovieController {
    private static Logger log= LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient LoadBalancerClient;
    @RequestMapping(value="/User/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public User findUserById(@PathVariable(value="id") Long id){
//        return this.restTemplate.getForObject("http://localhost:8000/"+id,User.class);
        return this.restTemplate.getForObject("http://simple-provider-user/"+id,User.class);
    }
    @RequestMapping(value="/log-instance",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public void logUserInstance() {
        ServiceInstance serviceInstance = LoadBalancerClient.choose("simple-provider-user");
        log.info("{}:{}:{}",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
    }
}
