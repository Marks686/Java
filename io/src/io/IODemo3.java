package io;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-20
 * Time: 16:19
 */
public class IODemo3 {
    public static void main(String[] args) {
        File file = new File("./test.txt");
        file.delete();
    }
}
