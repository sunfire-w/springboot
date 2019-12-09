package com.platform.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

;

@Data
@Component
@ConfigurationProperties(prefix = "config.author")
@PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
/**
 * 配置文件数据读取
 */
public class ConfigProperties {
    private String name;
    private String age;
    private String addr;
}
