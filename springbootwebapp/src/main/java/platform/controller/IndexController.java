package platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/2 0002.
 */
@Controller
@RequestMapping(value = "test")
public class IndexController {
    @RequestMapping(value = "/")
    public String news(Model model, HttpSession httpSession){
        System.out.println("enter VelocityController -----------------");
        // 在页面上用$userName取值
        model.addAttribute("userName","sdfsdffffffffffffffffffffffffffffffffffff"); // 在视图模板文件中即可通过key获取value
        return "news";
    }
    /**
     * 走Velocity模板页面
     */
//    @RequestMapping("news")
//    public ModelAndView testVelocity() {
//        System.out.println("enter VelocityController -----------------");
//        ModelAndView mv = new ModelAndView("news");
//        mv.addObject("page_title", "Test Page");  // 设置页面标题
//        mv.addObject("now", new Date());
//        mv.addObject("num", 232104953.12979978058145913);
//        return mv;
//    }

}
