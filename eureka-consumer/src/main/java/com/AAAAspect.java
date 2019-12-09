package com;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerStats;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerContext;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AAAAspect {
    @Autowired
    SpringClientFactory springClientFactory;

    @Around(value = "execution (* org.springframework.cloud.client.loadbalancer.LoadBalancerClient.reconstructURI(..)))")
    public Object reconstructURIAround(final ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(Thread.currentThread().getName()+"$$$$$$$$$$$reconstructURIAround");
        Object[] objects = joinPoint.getArgs();
        ServiceInstance instance = (ServiceInstance) objects[0];
        Server server = new Server(instance.getHost(), instance.getPort());

        if (objects != null) {
//            iLoadBalancer.markServerDown(server);
        }
//        springClientFactory.getLoadBalancer(instance.getServiceId());
        RibbonLoadBalancerContext context = springClientFactory.getLoadBalancerContext(instance.getServiceId());
        ServerStats serverStats = context.getServerStats(server);

        Object obj = joinPoint.proceed();
        log.info("======================GO===================================");
        log.info(serverStats.toString());
        log.info("======================GO end===================================");

        /**
         * 连续网络链接失败2次以上，迅速标记该provider下线
         */
        int n = serverStats.getSuccessiveConnectionFailureCount();
        if(n > 0){
            context.getLoadBalancer().markServerDown(server);
        }
        return obj;
    }
}