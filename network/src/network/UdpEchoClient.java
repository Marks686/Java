package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-25
 * Time: 19:26
 */
//UDP 版本的回显客户端
public class UdpEchoClient {
    private DatagramSocket socket = null;

    private String serverIp = null;
    private int serverPort = 0;
    //让操作系统自动分配端口 不需要显式绑定一个端口
    //一次通信需要两个IP 两个端口
    //客户端的ip是 127.0.0.1已知
    //客户端的 port是系统自动分配的
    //服务器的ip 和 端口 也需要告诉客户端 才能顺利发送消息给服务器
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }
    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);

        while (true){
            //1. 从控制台读取要发送的数据
            System.out.print("> ");
            String request = scanner.next();
            if(request.equals("exit")){
                System.out.println("goodbye");
                break;
            }
            //2. 构造UDP请求并发送
            //构造Packet 的时候需要把serverIp和port都传入过来,IP地址需要填写32位整数形式
            //上述的IP地址是一个字符串 所以需要用InetAddress.getByName(serverIp)转换
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            //3. 读取服务器UDP响应 并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            //4. 把解析好的结果显示出来
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
