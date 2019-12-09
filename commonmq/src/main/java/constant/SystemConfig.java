package constant;

/**
 * Created by Administrator on 2019/8/12 0012.
 */
public class SystemConfig {
    public static final String SYSTEMNAME = "hotelproduct";

    /**
     * MQ路由规则为 topic(完全匹配binding key与routing key) 的交换器
     */
    public static final String MQEXCHANGE = "hotelproduct_x_exchange";

    /**
     * MQ路由 binding key
     */
    public static final String MQROUTEKEY= "hotelproduct_x_queue";

    /**
     * 延迟路由的名称
     */
    public static final String MQEXCHANGE_DELAY = "hotelproduct_delay_exchange";

    /**
     * 大交通全部错误保存队列声明
     */
    public static final String MQERRORROUTEKEY = "hotelproduct_error_queue";
}
