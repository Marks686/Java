package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-27
 * Time: 0:03
 */
public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("启动服务器!");
        //此处使用CachedThreadPool ,使用FixedThreadPool不太合适(线程数不太应该是固定的 )
        ExecutorService threadPool = Executors.newCachedThreadPool();
        while (true) {
            //使用这个clientSocket和具体的客户端进行交流
            Socket clinentSocket = serverSocket.accept();
            //此处使用多线程处理
            /*Thread t = new Thread(()->{
                processConnection(clinentSocket);
            });*/
            //使用线程池
            threadPool.submit(()->{
                processConnection(clinentSocket);
            });
        }
    }
    //使用这个方法处理一个连接 一个连接对应一个客户端
    //可能涉及到多次交互
    private void processConnection(Socket clinentSocket) {
        //获得客户端IP和端口
        System.out.printf("[%s:%d] 客户端上线!\n",clinentSocket.getInetAddress().toString(),clinentSocket.getPort());
        // 基于上述socket对象和客户端进行通信
        try(InputStream inputStream = clinentSocket.getInputStream();
            OutputStream outputStream = clinentSocket.getOutputStream()){
            //由于要处理多个请求和响应,也是使用循环
            while (true){
                //1. 读取请求
                Scanner scanner = new Scanner(inputStream);
                if(!scanner.hasNext()){
                    //没有下一个数据 说明读完了 (客户端关闭了连接)
                    System.out.printf("[%s:%d] 客户端下线!\n",clinentSocket.getInetAddress().toString(),clinentSocket.getPort());
                    break;
                }
                //此处使用next是一直读取到换行符/空格/其他空白符结束
                //但是结果不包含上述空白符
                String request = scanner.next();
                //2. 根据请求响应
                String response = process(request);
                //3. 返回响应结果
                //outputStream没有write String这样的功能 可以把String里的字节数组拿出来 进行写入
                //也可以用字符流来转换一下
                PrintWriter printWriter = new PrintWriter(outputStream);
                //此处使用println来写入 让结果中带有一个\n 换行 方便对端来接收解析
                printWriter.println(response);
                //flush用来刷新缓冲区 保证当前写入的数据 确实是发送出去了
                printWriter.flush();
                System.out.printf("[%s:%d] req: %s; resp: %s \n",clinentSocket.getInetAddress().toString(),clinentSocket.getPort(),
                        request,response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                clinentSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String process(String request) {
        return request;
    }
    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
