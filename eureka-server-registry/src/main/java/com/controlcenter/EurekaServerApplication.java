package com.controlcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2019/7/16 0016.
 */
@EnableEurekaServer
@SpringBootApplication
@ImportResource({"classpath:spring-conf/spring-context.xml"})
public class EurekaServerApplication {
    public static void main(String [] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
