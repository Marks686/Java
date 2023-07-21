package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-21
 * Time: 15:48
 */
public class IODemo9 {
    //写操作
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("d:/test.txt")){
            writer.write("hello world");
            writer.flush();//手动刷新缓冲区
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
