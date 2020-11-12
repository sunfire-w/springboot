package procthrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import procthrift.service.Hello;

import java.nio.channels.SocketChannel;

/**
 * Created by Administrator on 2020/1/20 0020.
 */
public class ReceviedStart {


    public static void main( String[] args ) throws TException {

        TFramedTransport m_transport = new TFramedTransport(new TSocket("127.0.0.1", 6666,2000));
        TBinaryProtocol binaryProtocol=new TBinaryProtocol(m_transport);
        Hello.Client client=new Hello.Client(binaryProtocol);

        try {
            m_transport.open();
            String result=client.helloString("sdfdsfsdfsdfsdfsdfdsf");
            System.out.println("res = " + result);
            m_transport.close();
        } catch (TException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
