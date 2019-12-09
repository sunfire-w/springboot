package platform.web;

import platform.exception.BusinessException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * MVC拦截器
 * 处理HTTP所有的请求
 * HttpServletRequest 请求，拦截数据
 */
public class WebInterceptors extends HandlerInterceptorAdapter implements HandlerInterceptor {
    /*
    *   在视图函数之前执行
    *   返回true, 继续执行视图函数
    *   返回false, 终止请求流程
    *   本函数的作用,:拒绝特定时间sentinel:forbidden:hours; 特定用户的sentinel:forbidden:users请求, 并记录startTime
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean going = true;
        long startTime = System.currentTimeMillis();
        String sid = request.getHeader("sid");
        Calendar ca = Calendar.getInstance();
        String  currentHour = String.valueOf(ca.get(Calendar.HOUR_OF_DAY));
        try {
            String isForbidHour = "platform";
            if (isForbidHour.equals(sid)==false) {
                going=false;
                throw new BusinessException("无效的请求，身份验证失败！");
            }
        } catch (Exception e) {
            throw  e;
        }
        return going;
    }
}
