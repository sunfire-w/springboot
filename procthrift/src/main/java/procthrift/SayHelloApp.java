package procthrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.*;
import procthrift.service.Hello;
import procthrift.service.impl.grentServiceImpl;

/**
 * Hello world!
 *
 */
public class SayHelloApp
{
    private static grentServiceImpl  grentService=new grentServiceImpl();
    private static int m_thriftPort = 6666;
    private static TServer m_server = null;
    private static void createConnection() throws TTransportException {

        TProcessor p= new Hello.Processor<Hello.Iface>(grentService);
        TNonblockingServerSocket socket=new TNonblockingServerSocket(m_thriftPort);
        TNonblockingServer.Args noArgs=new TNonblockingServer.Args(socket);
        noArgs.processor(p);
        noArgs.transportFactory(new TFramedTransport.Factory());
        noArgs.protocolFactory(new TBinaryProtocol.Factory());

        // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
        m_server = new TNonblockingServer(noArgs);
    }
    public static boolean start()
    {
        try {
            createConnection();
        } catch (TTransportException e) {
            System.out.println("start server error!" + e);
            return false;
        }
        System.out.println("service at port: " + m_thriftPort);
        m_server.serve();
        return true;
    }
    public static void main( String[] args )
    {
        System.out.print("启动Thrift服务!!!");
        if(!start())
        {
            System.exit(0);
        }
        System.out.print("结束Thrift服务!!!");
    }
}
