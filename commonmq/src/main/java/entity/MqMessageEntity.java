package entity;

import java.io.Serializable;

/**
 * 接收mq的内容实体
 *
 * @author morgan 2017-07-19
 *
 */
public class MqMessageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务主健-如订单号
     */
    private String businesKey;

    /**
     * 操作名称
     */
    private String mqName;

    /**
     * 操作；
     */
    private String operation;

    /**
     * 内容
     */
    private String content;

    public String getBusinesKey() {
        return businesKey;
    }

    public void setBusinesKey(String businesKey) {
        this.businesKey = businesKey;
    }

    public String getMqName() {
        return mqName;
    }

    public void setMqName(String mqName) {
        this.mqName = mqName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
