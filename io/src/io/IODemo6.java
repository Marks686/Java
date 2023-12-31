package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-20
 * Time: 17:05
 */

//使用字节流来读取文件
public class IODemo6 {
    public static void main(String[] args) throws IOException {
        //创建InputStream 对象的时候,使用绝对路径或者相对路径都是可以的 也可以使用File对象
        InputStream inputStream = new FileInputStream("d:/test.txt");
        //读操作
        /*while (true){
            int b = inputStream.read();
            if(b == -1){
                //读取完毕
                break;
            }
            System.out.printf("%x\n", + (byte)b);
        }*/
        while (true){
            byte[] buffer = new byte[1024];
            int len = inputStream.read(buffer);
            if(len == -1){
                break;
            }
            for (int i = 0; i < len; i++) {
                System.out.printf("%x\n",buffer[i]);
            }
        }
        inputStream.close();
    }
}
