package procthrift;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2020/1/22 0022.
 */

@Slf4j
public class NIOReactor {

    public static void main(String[] args){
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(9090));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server is open!");
            while (true) {
                if (selector.select() > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    while (iterator.hasNext()) {

                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            int len = 0;
                            //当管道的数据都读取完毕了
                            while ((len = (socketChannel.read(byteBuffer))) > 0) {
                                byteBuffer.flip();
                                System.out.println(new String(byteBuffer.array(), 0, len));
                                byteBuffer.clear();
                            }
                        } else if (selectionKey.isAcceptable()) {
                            //第一次链接到server，需要构建一个通道
                            ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) selectionKey.channel();
                            //开通通道
                            SocketChannel socketChannel = acceptServerSocketChannel.accept();
                            //设置为非堵塞
                            socketChannel.configureBlocking(false);
                            //注册可读的监听事件
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println("[server]接收到新的链接");
                        }
                        iterator.remove();
                    }
                }

            }
        } catch (IOException e) {
            log.error("[server]异常出现，信息为{}", e);
        }
    }
}
