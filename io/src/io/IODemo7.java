package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-21
 * Time: 15:18
 */
public class IODemo7 {
    public static void main(String[] args) throws IOException {
        //写文件
        try(OutputStream outputStream = new FileOutputStream("d:/test.txt") ){
            outputStream.write(97);
            outputStream.write(98);
            outputStream.write(99);
            outputStream.write(100);
        }
    }
}
