package com.platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {
    Logger log = LoggerFactory.getLogger(getClass());
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }
}