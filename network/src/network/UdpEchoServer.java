package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;



/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-25
 * Time: 19:26
 */
//UDP 版本的回显服务器
public class UdpEchoServer {
    //网络编程本质操作网卡 操作系统内核中使用"socket"这样的文件抽象表示网卡
    //先创建socket对象
    private DatagramSocket socket = null;

    //对于服务器来说 创建socket对象的同时 要让它绑定一个具体的端口号
    //服务器一定要关联上一个具体的端口
    //服务器是网络传输中,被动的一方,如果是操作系统随机分配的端口,
    // 此时客户端就不知道这个端口是啥,也就无法进行通信
    public UdpEchoServer(int prot) throws SocketException {
        socket = new DatagramSocket(prot);
    }
    public void start() throws IOException {
        System.out.println("服务器启动!");
        //服务器不是只给一个客户端服务 它需要给很多客户端提供服务
        while (true){
            //只要有客户端过来 就提供服务
            //1.读取客户端发来的请求
            //   receive 方法的参数是一个输出型参数,需要先构造好个空白的 DatagramPacket对象
            //交给receive来进行填充
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            //此时DatagramPacket是一个特殊的对象 并不方便直接进行处理 我们可以把这里包含的数据拿出来
            //构造成一个字符串
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            // 2. 根据请求计算响应 此处是回显服务器 响应和请求相同
            String response = process(request);
            //3. 把响应程序写回客户端 send的参数也是DatagramPacket 需要把这个Packet对象构造好
            // 此处构造的响应对象 不能用空的字节数组构造,要用响应数据来构造
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            // 4.打印这次请求响应的处理中间结果
            System.out.printf("[%s:%d] req: %s; resp:%s \n", requestPacket.getAddress().toString(),
                    responsePacket.getPort(),request,response);
        }
    }
    //"根据请求计算响应"
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        //端口号 1024--65536 之间随便指定
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
