package util;

import com.rabbitmq.client.AMQP;
import constant.MqQueueDelay;
import entity.MQMessage;
import org.springframework.amqp.core.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtils {

    /**
     *  延迟消息包装
     *  @param backOffMultiplier 步长
     *  @param redeliveryDelay 延迟时间
     *  @return BasicProperties 返回消息属性包装
     *
     */
    public static AMQP.BasicProperties genDelayMsgProperties(int backOffMultiplier, long redeliveryDelay){

        Map<String,Object> headers = new HashMap<String,Object>();
        headers.put("__TypeId__", MQMessage.class.getName());

        long inteval = backOffMultiplier * redeliveryDelay;

        AMQP.BasicProperties basicProperties =  new AMQP.BasicProperties("text/plain",
                null,
                headers,
                2,
                0, null, null, ""+inteval,
                null, null, null, null,
                null, null);

        return basicProperties;
    }
    /**
     *  延迟消息包装
     *  @param message  当前MQ消息
     *  @param backOffMultiplier 步长
     *  @param redeliveryDelay 延迟时间
     *  @return BasicProperties 返回消息属性包装
     *
     */
    public static AMQP.BasicProperties genDelayMsgProperties(Message message, int backOffMultiplier, long redeliveryDelay){

        long count = getDeathCount(message);
        Map<String,Object> headers = message.getMessageProperties().getHeaders();

        count++;

        long inteval = count * backOffMultiplier * redeliveryDelay;

        AMQP.BasicProperties basicProperties =  new AMQP.BasicProperties("text/plain",
                null,
                headers,
                2,
                0, null, null, ""+inteval,
                null, null, null, null,
                null, null);

        return basicProperties;
    }
    /**
     *  获取Death次数
     *  @param message  当前MQ消息
     *  @return int 次数
     *
     */
    public static long getDeathCount(Message message){
        long count = 0;
        try{
            Map<String,Object> headers = message.getMessageProperties().getHeaders();
            List<Map<String,Object>> deathInfoList = (List<Map<String,Object>>)headers.get(MqQueueDelay.DELAY_HEADER_NAME);
            if(deathInfoList!=null && deathInfoList.size() > 0){
                count = (Long)deathInfoList.get(0).get(MqQueueDelay.DELAY_HEADER_CCOUNT_NAME);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return count;
    }
}