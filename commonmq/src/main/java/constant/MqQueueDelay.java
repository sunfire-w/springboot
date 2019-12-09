package constant;


/**
 *
 *   延迟队列相关配置
 *   @author Suoron
 *   2017/02/06
 *
 */

public class MqQueueDelay {

    /* 默认延迟交换机 */
    public static final String DEFAULT_DELAY_EXCHANGE = "shinetour_delay_mq_exchange";

    /* 默认延迟时间 */
    public static final long DEFAULT_DELAY_SECOND = 15000;

    /* 默认RouteKey */
    public static final String DEFAULT_DELAY_KEY = "shinetour_delay_key";

    /* 默认header name */
    public static final String DELAY_HEADER_NAME = "x-death";
    public static final String DELAY_HEADER_CCOUNT_NAME = "count";

}