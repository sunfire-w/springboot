package procthrift.service.impl;

import org.apache.thrift.TException;
import procthrift.service.Hello;

/**
 * Created by Administrator on 2020/1/20 0020.
 */
public class grentServiceImpl implements Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        return "x000001:"+"66666:"+"88888:"+para;
    }
}
