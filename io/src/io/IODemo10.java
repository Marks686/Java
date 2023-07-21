package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-21
 * Time: 15:54
 */
public class IODemo10 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = new FileInputStream("d:/test.txt")) {
            Scanner scanner = new Scanner(inputStream);
            //此时读取的内容是从文件中读取
            scanner.next();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
