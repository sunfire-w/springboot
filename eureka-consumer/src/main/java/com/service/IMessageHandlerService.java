package com.service;

import entity.MqMessageEntity;

/**
 * Created by Administrator on 2019/8/12 0012.
 */
public interface IMessageHandlerService {
    /**
     * 处理MQ信息
     *
     * @param mqMessage 请求参数
     */
    public void handleMessage(MqMessageEntity mqMessage);
}
