package com.controlcenter;

import com.netflix.appinfo.InstanceInfo;
import common.SendMQUtils;
import constant.SystemConfig;
import entity.MessageNote;
import entity.MqMessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import util.JsonUtil;
import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Component
public class EurekaStateChangeListener {

//    @Value("${iptable.platform}")
//    private String platform;

    private static Logger logger = LoggerFactory.getLogger(EurekaStateChangeListener.class);
    private static final String COLON = ":";
    //@Resource
    private SendMQUtils sendMQUtils;

    @EventListener//(condition = "#event.replication==false")
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {

        // 服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        Objects.requireNonNull(appName, "服务名不能为空!");
        MqMessageEntity entity = new MqMessageEntity();
        entity.setBusinesKey(eurekaInstanceCanceledEvent.getServerId()+ new Date().getTime());
        MessageNote messageNote=new MessageNote();
        messageNote.setType("DOWN");
        messageNote.setMessage("服务下线，通知客户端取消订阅！");
        messageNote.setServiceId(serverId);
        entity.setContent(JsonUtil.getJSONString(messageNote));
        entity.setMqName("shinetour");
        entity.setOperation("shinetour");
        logger.info(serverId+"服务下线MQ发送,参数：" + JsonUtil.getJSONString(messageNote));
        sendMQUtils.sendMsg(SystemConfig.MQEXCHANGE, SystemConfig.MQROUTEKEY, SystemConfig.SYSTEMNAME, entity, 50000);
        logger.info(">>>>>>> 失效服务:{},已被剔除!", serverId);
}

    @EventListener//(condition = "#event.replication==false")
    public void listen(EurekaInstanceRegisteredEvent event) {
        // 服务注册
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String appName = instanceInfo.getAppName();
        Objects.requireNonNull(appName, "服务名不能为空!");

//        SetOperations<String, String> opsForSet = redisTemplate.opsForSet();
//        opsForSet.add((platform + appName).toLowerCase(), instanceInfo.getIPAddr() + COLON + instanceInfo.getPort());
        logger.info(">>>>>>> 服务名:{},端口号:{},已缓存至redis", appName, instanceInfo.getPort());
    }

    @EventListener//(condition = "#event.replication==false")
    public void listen(EurekaInstanceRenewedEvent event) {
        // 服务续约
        logger.info(">>>>>>>>>>>>>>>Server续约:" + event.getServerId());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        // 注册中心启动
        logger.info(">>>>>>>>>>>>>>>Server注册中心:" + event);
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        // Server启动
        logger.info(">>>>>>>>>>>>>>>Server启动:" + event);
    }
}