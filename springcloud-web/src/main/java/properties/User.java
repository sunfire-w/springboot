package properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Data
@Component
@ConfigurationProperties(prefix = "com.springcloud")
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
@EnableConfigurationProperties
public class User {
    private String name;
    private Integer age;
}
