package io;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-20
 * Time: 16:27
 */
public class IODemo4 {
    public static void main(String[] args) {
        File dir = new File("./test/aaa/bbb");
        dir.mkdirs();
    }
}
