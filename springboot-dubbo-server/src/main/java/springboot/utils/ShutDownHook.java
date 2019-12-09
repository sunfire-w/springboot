package springboot.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by Administrator on 2019/6/18 0018.
 */
public class ShutDownHook extends  Thread{
    private Log logger = LogFactory.getLog(getClass());

    private ApplicationContext applicationContext;

    public ShutDownHook(ApplicationContext applicationContext ){
        super();
        this.applicationContext = applicationContext;
    }

    @Override
    public void run() {
        logger.info("Start clean the login info.");
        //关机前的个性化descory
        logger.info("Socket server shutdown");
    }
}
