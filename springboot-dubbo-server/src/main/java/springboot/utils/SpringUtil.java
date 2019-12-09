package springboot.utils;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import springboot.ServerApplication;

/**
 * Created by Administrator on 2019/6/18 0018.
 */
public class SpringUtil {
    private static ApplicationContext ctx=null;

    public static ApplicationContext getApplicationContext(String[] args){
        if(ctx==null){
            synchronized (SpringUtil.class){
                if(ctx==null){
                    if(args==null){
                        args=new String[]{};
                    }
                    ctx=new SpringApplicationBuilder().sources(ServerApplication.class).web(false).run(args);
                }
            }
        }
        return ctx;
    }

    public static  <T> T getBean(Class<T> clazz){
        return getApplicationContext(null).getBean(clazz);
    }

    public static Object getBean(String beanId){
        return getApplicationContext(null).getBean(beanId);
    }

}
