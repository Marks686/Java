package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-27
 * Time: 1:53
 */
public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp,int serverPort) throws IOException {
        //Socket 构造方法能够识别 电分十进制格式的IP地址 比DatagramPacket 更方便
        //new 这个对象的同时,就会进行 TCP 连接操作
        socket = new Socket(serverIp,serverPort);
    }

    public void start(){
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()){
            while (true){
                //1. 先从键盘上读取用户输入的内容
                System.out.println("> ");
                String request = scanner.next();
                if(request.equals("exit")){
                    System.out.println("goodbye");
                    break;
                }
                //2.  把读到的内容构造成请求 发送给服务器
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                //加flush保证数据确实发送出去了
                printWriter.flush();
                //3. 读取服务器响应
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                //4. 把响应显示到界面上
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}
