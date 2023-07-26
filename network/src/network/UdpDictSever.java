package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-26
 * Time: 15:50
 */
//对于UdpDictSever来说 大部分东西和UdpEchoServer一样
//主要是 "根据请求计算响应"这个步骤不太一样
public class UdpDictSever extends UdpEchoServer{
    private Map<String,String> dict = new HashMap<>();

    public UdpDictSever(int prot) throws SocketException {
        super(prot);

        //给dict设置内容
        dict.put("cat","小猫");
        dict.put("dog","小狗");
        dict.put("fuck","卧槽");
        //这里可以无限多的设置键值对
    }
    @Override
    public String process(String request){
        //查词典的过程
        return dict.getOrDefault(request,"当前单词没有查到结果!");
    }

    public static void main(String[] args) throws IOException {
        UdpDictSever sever = new UdpDictSever(9090);
        sever.start();
    }
}
