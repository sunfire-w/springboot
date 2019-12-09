package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/8/12 0012.
 */
@Data
public class MessageNote implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 服务编号
     */
    String serviceId;
    /**
     * 服务名称
     */
    String serviceName;
    /**
     * 消息类型
     */
    String type;
    /**
     * 消息信息
     */
    String message;
}
