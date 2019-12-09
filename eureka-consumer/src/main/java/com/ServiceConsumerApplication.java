package com;

import com.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2019/8/1 0001.
 */
@SpringBootApplication
@EnableFeignClients
@ImportResource({"classpath:spring-conf/spring-context.xml"})
public class ServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class,args);
//        ApplicationContext context =SpringApplication.run(ServiceConsumerApplication.class,args);
//        ProductService productService = context.getBean(ProductService
//                .class);
    }
}
