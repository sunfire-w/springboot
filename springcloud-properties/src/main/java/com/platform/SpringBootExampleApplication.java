package com.platform;

import com.platform.properties.ConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication  implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private ConfigProperties configProperties;
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }
    public void run(String... args) throws Exception {
        String config = "config.author.name: " + configProperties.getName()
                + ", config.author.age:" + configProperties.getAge()
                + ", config.author.addr:" + configProperties.getAddr();
        log.info("SpringBoot2.0实现自定义properties配置文件与JavaBean映射:" + config);
    }
}