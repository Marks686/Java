package io;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-20
 * Time: 16:51
 */
public class IODemo5 {
    public static void main(String[] args) {
        File file = new File("./test");
        File dest = new File("./testAAA");
        file.renameTo(dest);
    }
}
