package com.Controller;

import org.apache.catalina.Server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2019/7/16 0016.
 */
@RestController
public class ProducerService {

    @RequestMapping(value="/pengproducer", method = RequestMethod.POST)
    public String sayHello(HttpServletRequest request){
        return "hello world"+request.getSession()+":"+request.getServerPort();
    }

}
