package com.book.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
//import org.springframework.test.context.web.WebAppConfiguration;

//import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2019/12/25 0025.
 */
@SpringBootApplication
@ImportResource({"classpath:spring-conf/spring-context.xml"})
public class StartupApp {
    //private static final Logger LOGGER = LoggerFactory.getLogger(StartupApp.class.getName());
    //@Bean
//    public CountDownLatch closeLatch(){
//        return new CountDownLatch(1);
//    }
    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(StartupApp.class, args
        );
//        try {
//
//            LOGGER.info("服务开始启动......");
//
//            System.setProperty("dubbo.application.logger","slf4j");
//
//            ApplicationContext ctx = new SpringApplicationBuilder()
//                    .sources(StartupApp.class)
//                    .web(false)
//                    .run(args);
//
//            ///< 注册个性化关闭hook
//            Runtime.getRuntime().addShutdownHook(new ShutDownHook(ctx));
//            CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
//            LOGGER.info("服务启动完成0000......");
//            closeLatch.await();
//
//            LOGGER.info("服务启动完成......");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("服务器启动异常", e);
//        }
    }
}