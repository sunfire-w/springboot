package com.service.impl;

import com.netflix.loadbalancer.*;
import com.service.IMessageHandlerService;
import entity.MessageNote;
import entity.MqMessageEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerContext;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.ribbon.FeignLoadBalancer;
import org.springframework.stereotype.Service;
import util.JsonUtil;

import java.util.List;

/**
 * Created by Administrator on 2019/8/12 0012.
 */
@Service
public class MessageHandlerServiceImpl implements IMessageHandlerService {
    private Logger log = LogManager.getRootLogger();
    @Autowired
    SpringClientFactory springClientFactory;
    @Autowired
    DiscoveryClient discoveryclient;
    @Override
    public void handleMessage(MqMessageEntity mqMessage) {
        if(mqMessage!=null)
        {
            MessageNote messageNote=(MessageNote)JsonUtil.parseObject(mqMessage.getContent(), MessageNote.class);
            if(messageNote.getType().equals("DOWN")){
                try {
                    log.info("服务下线操作！");

                    DynamicServerListLoadBalancer load=new  DynamicServerListLoadBalancer();
                    log.info("服务下线前:"+load.getServerList(false));
                    load.updateListOfServers();
                    log.info("服务下线后:"+load.getServerList(false));
//                    FeignLoadBalancer d=(ZoneAwareLoadBalancer<Server>) springClientFactory.getLoadBalancer(messageNote.getServiceId());
//                    ZoneAwareLoadBalancer<Server> lb = (ZoneAwareLoadBalancer<Server>) springClientFactory.getLoadBalancer(messageNote.getServiceId());
//                    Server server = lb.chooseServer();
//                    System.out.println("error->" + server.getHostPort());
//                    lb.markServerDown(server);
                    //服务下线
//                    RibbonLoadBalancerContext context = springClientFactory.getLoadBalancerContext(messageNote.getServiceId());
//                    List<ServiceInstance> serviceInstanceList = discoveryclient.getInstances(messageNote.getServiceId());
//                    ServiceInstance serviceInstance = serviceInstanceList.get(0);
//                    ILoadBalancer balancer=context.getLoadBalancer();
//                    List<Server> servers=balancer.getAllServers();
//                    Server server = new Server(serviceInstance.getHost(), serviceInstance.getPort());
//                    context.getLoadBalancer().markServerDown(server);
                    log.info("服务下线完成！");
                }catch (Exception ex){
                    log.info(ex);
                }
            }
        }
    }
}
