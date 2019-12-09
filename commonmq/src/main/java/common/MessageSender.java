package common;

import com.rabbitmq.client.Channel;
import entity.MQMessage;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.util.StringUtils;
import util.JsonUtil;
import util.MessageUtils;

import javax.annotation.Resource;

/**
 *
 *  消息发送器封装
 *  @author Suoron
 *  2017/01/11
 *
 */

public class MessageSender {

    private AmqpTemplate amqpTemplate;

    //@Resource
    //private RabbitTemplate rabbitTemplate;

    private String routingKey;

    @Resource
    CachingConnectionFactory connectionFactory;

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public void sendDataToQueue(MQMessage msg) throws AmqpException {
        if(StringUtils.isEmpty(msg.getExchange()))
        {
            amqpTemplate.convertAndSend(msg.getRouteKey(), msg);
        }else{
            amqpTemplate.convertAndSend(msg.getExchange(),msg.getRouteKey(), msg);
        }
    }
    /**
     *  消息延迟发送
     *  @param msg 消息内容
     *  @param  delayTimeOut 消息延迟ms后发送
     *  @throws AmqpException 消息发送失败异常
     *
     */
    public void sendDataToQueue(MQMessage msg,long delayTimeOut) throws AmqpException {
        Connection connection = null;
        Channel channel = null;

        try{
            connection = connectionFactory.createConnection();
            channel = connection.createChannel(false);
            channel.basicPublish(msg.getExchange(),msg.getRouteKey(),
                    MessageUtils.genDelayMsgProperties(1, delayTimeOut), JsonUtil.getJSONString(msg).getBytes());

        }catch(Exception ex){
            ex.printStackTrace();
            throw new AmqpException(ex.getMessage());
        }finally{
            if(channel != null && channel.isOpen()){
                try{
                    channel.close();
                }catch(Exception ex){}
            }
            if(connection != null && connection.isOpen()){
                try{
                    connection.close();
                }catch(Exception ex){}
            }
        }
    }
}
