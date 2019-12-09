package util;

import com.rabbitmq.client.Channel;
import constant.MqQueueDelay;
import org.springframework.amqp.core.Message;

/**
 * Created by Administrator on 2019/8/12 0012.
 */
public class MsgRetryUtils {
    /**
     *
     *  消息重试
     *  @param channel 当前会话
     *  @param message 当前消息
     *  @param queueName 延迟队列
     *  @param backOffMultiplier 步长
     *  @param redeliveryDelay 延迟时间
     *
     */
    public static void retrySend(Channel channel, Message message,
                                 String queueName,
                                 int backOffMultiplier, long redeliveryDelay) throws Exception{

        String delayQueue = queueName == null ? MqQueueDelay.DEFAULT_DELAY_EXCHANGE : queueName;

        channel.basicPublish(delayQueue,message.getMessageProperties().getReceivedRoutingKey() ,
                MessageUtils.genDelayMsgProperties(message,backOffMultiplier,redeliveryDelay), message.getBody());
    }
}
