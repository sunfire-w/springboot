package entity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Administrator on 2019/8/9 0009.
 */
public class MQMessage implements Serializable {


    private static final long serialVersionUID = -6487839157908352120L;

    private String exchange;      //交换器(选填)
    private String routeKey;      //路由key

    /* 系统信息 */
    private String source;        //来自哪个系统
    private long sendTime;     //发送时间

    private Object message;       //消息实体


    public MQMessage() {
    }


    public String getSource() {
        return source;
    }


    public void setSource(String source) {
        this.source = source;
    }


    public long getSendTime() {
        return sendTime;
    }


    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }


    public Object getMessage() {
        return message;
    }


    public void setMessage(Object message) {
        this.message = message;
    }


    public MQMessage(String exchange, String routeKey, Object message) {
        this.exchange = exchange;
        this.routeKey = routeKey;
        this.message = message;
    }


    public byte[] getSerialBytes() {
        byte[] res = new byte[0];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();
            res = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }
}