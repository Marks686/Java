package io;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-21
 * Time: 16:27
 */
public class IODemo12 {
    public static void main(String[] args) {
        //输入两个路径
        // 源 和 目标 (从哪里拷贝到哪里)
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要拷贝哪个文件: ");
        String srcPath = scanner.next();
        System.out.println("请输入要拷贝到哪个地方:");
        String destPath = scanner.next();
        File srcFile = new File(srcPath);
        if(!srcFile.isFile()){
            //如果源不是一个文件(是一个目录或者不存在)
            System.out.println("您当前输入的源路径有误");
            return;
        }
        File destFile = new File(destPath);
        if(destFile.isFile()){
            //如果已经存在了,认为也不能拷贝
            System.out.println("您当前输入的目标路径有误");
            return;
        }
        //进行拷贝操作
        try(InputStream inputStream = new FileInputStream(srcFile);
            OutputStream outputStream = new FileOutputStream(destFile)){
            //进行读写操作
            while (true){
                int b = inputStream.read();
                if(b == -1){
                    break;
                }
                outputStream.write(b);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
