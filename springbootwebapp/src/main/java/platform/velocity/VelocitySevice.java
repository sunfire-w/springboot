package platform.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;

/**
 * Created by Administrator on 2019/2/2 0002.
 */
@Service
public class VelocitySevice {
    public void initVecocity() {
        VelocityEngine ve=new VelocityEngine();
        //设置模板加载路径，这里设置的是class下
        ve.setProperty(Velocity.RESOURCE_LOADER, "class");
        ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        try {
            //进行初始化操作
            ve.init();
            //加载模板，设定模板编码
            Template t=ve.getTemplate("template/news.vm","gbk");
            //设置初始化数据
            VelocityContext context = new VelocityContext();
            //设置输出
            PrintWriter writer = new PrintWriter("D:\\helloword.html");
            //将环境数据转化输出
            t.merge(context, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
