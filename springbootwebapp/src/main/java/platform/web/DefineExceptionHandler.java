package platform.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import platform.entity.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * 拦截器抛出异常按特定格式输出
 */
public class DefineExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            Writer out = response.getWriter();
            BaseResponse responseData = new BaseResponse();
            responseData.setSuccess(1);
            responseData.setMessage(e.getMessage());
            responseData.setData(null);
            out.write(JSON.toJSONString(responseData));
        } catch (IOException e1) {
            try {
                Writer out = response.getWriter();
                BaseResponse responseData = new BaseResponse();
                responseData.setSuccess(1);
                responseData.setMessage(e1.getMessage());
                responseData.setData(null);
                out.write(JSON.toJSONString(responseData));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return new ModelAndView();
    }
}
