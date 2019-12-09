package com.handler;

import com.rabbitmq.client.Channel;
import com.service.IMessageHandlerService;
import common.BusinessException;
import common.SendMQUtils;
import constant.LogErrorCode;
import constant.SystemConfig;
import entity.MQMessage;
import entity.MqMessageEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import trace.TraceData;
import util.JsonUtil;

import javax.annotation.Resource;

public class MessageHandler implements ChannelAwareMessageListener {

    private Logger log = LogManager.getRootLogger();
    @Resource
    private IMessageHandlerService messageHandlerService;
    @Resource
    private SendMQUtils sendMQUtils;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {

            MQMessage mqMessage = (MQMessage) JsonUtil.parseObject(new String(message.getBody()),
                    MQMessage.class);
            if (mqMessage == null) {
                throw new BusinessException("-9999", "接收到的消息队列实体内容为空");
            }
            log.info("[Result:{}] {}|{}|{}", LogErrorCode.SERVICE_NORMAL.getCode(), TraceData.traceId.get(), "接收MQ成功-hotelproduct", JsonUtil.getJSONString(mqMessage));

            String content = mqMessage.getMessage().toString();
            MqMessageEntity mqMessageEntity = (MqMessageEntity) JsonUtil.parseObject(content, MqMessageEntity.class);
            messageHandlerService.handleMessage(mqMessageEntity);
            //手动标识MQ处理成功
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
			/* 延迟2秒后再处理,步长为次数，默认最大重试10次 */
            sendMQUtils.retrySend2(channel, message, SystemConfig.MQEXCHANGE_DELAY, 2000, e, SystemConfig.MQERRORROUTEKEY, SystemConfig.SYSTEMNAME);
            //手动标识MQ处理成功
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }

    }

}
