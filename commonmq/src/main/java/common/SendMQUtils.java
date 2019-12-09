package common;

import com.rabbitmq.client.Channel;
import constant.LogErrorCode;
import entity.MQMessage;
import entity.MqMessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import trace.TraceData;
import util.JsonUtil;
import util.MessageUtils;
import util.MsgRetryUtils;

import javax.annotation.Resource;
/**
 * 消息推送公共类
 *
 * @author 罗彦文 日期：2017-06-30
 */
public class SendMQUtils {
    @Resource
    private MessageSender messageSender;
    private static final Logger log = LoggerFactory.getLogger(SendMQUtils.class);
    /**
     * 发送MQ
     *
     * @param exchange 交换器(选填)
     * @param routeKey 路由
     * @param source 来自哪个系统
     * @param entity 内容
     */
    public void sendMsg(String exchange, String routeKey, String source, MqMessageEntity entity) {
        this.sendMsg(exchange, routeKey, source, null, entity);
    }

    /**
     * 发送MQ
     *
     * @param exchange 交换器(选填)
     * @param routeKey 路由
     * @param source 来自哪个系统
     * @param sendTime 发送时间
     * @param entity 内容
     */
    public void sendMsg(String exchange, String routeKey, String source, Long sendTime, MqMessageEntity entity) {

        this.sendMsg(exchange, routeKey, source, sendTime, entity, -1);
    }

    /**
     * 发送MQ
     *
     * @param exchange 交换器(选填)
     * @param routeKey 路由
     * @param source 来自哪个系统
     * @param entity 内容
     * @param delayTimeOut 消息延迟ms后发送
     */
    public void sendMsg(String exchange, String routeKey, String source, MqMessageEntity entity, long delayTimeOut) {
        if (delayTimeOut <= 0) {
            this.sendMsg(exchange, routeKey, source, null, entity);
        } else {
            this.sendMsg(exchange, routeKey, source, null, entity, delayTimeOut);
        }
    }

    /**
     * 发送MQ
     *
     * @param exchange 交换器(选填)
     * @param routeKey 路由
     * @param source 来自哪个系统
     * @param sendTime 发送时间
     * @param entity 内容
     * @param delayTimeOut 消息延迟ms后发送
     */
    public void sendMsg(String exchange, String routeKey, String source, Long sendTime, MqMessageEntity entity, long delayTimeOut) {

        MQMessage msg = new MQMessage();

        if (StringUtils.isBlank(routeKey)) {
            throw new BusinessException("推送消息路由为空");
        }

        if (entity == null || StringUtils.isBlank(entity.getContent())) {
            throw new BusinessException("推送消息内容为空");
        }

        if (StringUtils.isNotBlank(exchange)) {
            msg.setExchange(exchange);
        }

        msg.setRouteKey(routeKey);

        if (StringUtils.isNotBlank(source)) {
            msg.setSource(source);
        }

        if (sendTime != null && sendTime > 0) {
            msg.setSendTime(sendTime);
        }

        String mqContent = JsonUtil.getJSONString(entity);
        msg.setMessage(mqContent);

        if (delayTimeOut <= 0) {
            messageSender.sendDataToQueue(msg);
        } else {
            messageSender.sendDataToQueue(msg, delayTimeOut);
        }
    }

    /**
     * Morgan 2017-07-19 消息重试，默认最大重试10次
     *
     * @param channel 当前会话
     * @param message 当前消息
     * @param queueName 延迟队列
     * @param redeliveryDelay 最终延迟时间=次数*次数*延迟时间
     *
     */
    public void retrySend(Channel channel, Message message, String queueName, long redeliveryDelay, Exception ex) throws Exception {
        this.retrySend(channel, message, queueName, 0, redeliveryDelay, 10, ex);
    }

    /**
     * Morgan 2017-07-19 消息重试，10次之后还是保留在原队列
     *
     * @param channel 当前会话
     * @param message 当前消息
     * @param queueName 延迟队列
     * @param backOffMultiplier 步长，小于等于0时赋值为次数+1
     * @param redeliveryDelay 延迟时间；最终延迟时间=次数*步长*延迟时间
     * @param maxCount 最大重试次数，小于等于0时赋值为10
     *
     */
    public void retrySend(Channel channel, Message message, String queueName, int backOffMultiplier, long redeliveryDelay, int maxCount, Exception ex) throws Exception {

        long count = MessageUtils.getDeathCount(message);
        log.error("[ErrorCode:{}] {}|{}|{}", LogErrorCode.SERVICE_FAILURE.getCode(), TraceData.traceId.get(), "处理MQ失败，次数：" + count, ex.getMessage());
        ex.printStackTrace();
		/* 延迟2秒后再处理,步长为2，最多重复10次,从0开始 */
        if (maxCount <= 0) {
            maxCount = 10;
        }
        if (backOffMultiplier <= 0) {
            backOffMultiplier = Integer.parseInt(String.valueOf(count)) + 1;
        }
        if (count < maxCount) {
            MsgRetryUtils.retrySend(channel, message, queueName, backOffMultiplier, redeliveryDelay);
        } else {
            // 放入队列中记录下来，暂时放后1小时*次数
            MsgRetryUtils.retrySend(channel, message, queueName, backOffMultiplier, 3600000);
        }
    }

    /**
     * Morgan 2017-07-19 消息重试，默认最大重试10次，10次之后放入错误队列
     *
     * @param channel 当前会话
     * @param message 当前消息
     * @param queueName 延迟队列
     * @param redeliveryDelay 最终延迟时间=次数*次数*延迟时间
     * @param routeKey 错误路由
     * @param source 来自哪个系统
     *
     */
    public void retrySend2(Channel channel, Message message, String queueName, long redeliveryDelay,
                           Exception ex, String routeKey, String source) throws Exception {
        this.retrySend2(channel, message, queueName, 0, redeliveryDelay, 10, ex, routeKey, source);
    }

    /**
     * Morgan 2017-10-25 消息重试，10次之后放入错误队列
     *
     * @param channel 当前会话
     * @param message 当前消息
     * @param queueName 延迟队列
     * @param backOffMultiplier 步长，小于等于0时赋值为次数+1
     * @param redeliveryDelay 延迟时间；最终延迟时间=次数*步长*延迟时间
     * @param maxCount 最大重试次数，小于等于0时赋值为10
     * @param routeKey 错误路由
     * @param source 来自哪个系统
     *
     */
    public void retrySend2(Channel channel, Message message, String queueName, int backOffMultiplier, long redeliveryDelay, int maxCount,
                           Exception ex, String routeKey, String source) throws Exception {

        long count = MessageUtils.getDeathCount(message);
        log.error("[ErrorCode:{}] {}|{}|{}", LogErrorCode.SERVICE_FAILURE.getCode(), TraceData.traceId.get(), "处理MQ失败，次数：" + count, ex.getMessage());
        ex.printStackTrace();
		/* 延迟2秒后再处理,步长为2，最多重复10次,从0开始 */
        if (maxCount <= 0) {
            maxCount = 10;
        }
        if (backOffMultiplier <= 0) {
            backOffMultiplier = Integer.parseInt(String.valueOf(count)) + 1;
        }
        if (count < maxCount) {
            MsgRetryUtils.retrySend(channel, message, queueName, backOffMultiplier, redeliveryDelay);
        } else {
            // 发到错误队列去
            redeliveryDelay = 2592000000L;
            MQMessage shinetourMessage = (MQMessage) JsonUtil.parseObject(new String(message.getBody()), MQMessage.class);
            MqMessageEntity mqEntity = null;
            if (shinetourMessage != null) {
                String content = shinetourMessage.getMessage().toString();
                mqEntity = (MqMessageEntity) JsonUtil.parseObject(content, MqMessageEntity.class);
            }
            sendMsg(queueName, routeKey, source, mqEntity);
        }
    }

}