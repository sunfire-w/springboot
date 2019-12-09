package trace;

/**
 * Created by Administrator on 2019/8/12 0012.
 */
public class TraceData {
    public static ThreadLocal<Long> traceId = new ThreadLocal<Long>();

    public static ThreadLocal<String> language = new ThreadLocal<String>();
}
