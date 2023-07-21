package io;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-20
 * Time: 16:14
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./test.txt");

        file.createNewFile();

        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
