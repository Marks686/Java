package io;

import java.io.File;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-21
 * Time: 16:01
 */
public class IODemo11 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //让用户输入指定搜索的目录
        //Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的路径: ");
        String basePathh = scanner.next();
        //针对用户输入进行判定
        File root = new File(basePathh);
        if(!root.isDirectory()){
            //路径不存在,或者只是一个普通文件
            System.out.println("输入目录有误");
            return;
        }
        //再让用户输入一个要删除的文件名
        System.out.println("请输入要删除的文件名: ");
        String nameToDelete = scanner.next();

        //针对指定路径进行扫描,递归操作
        //先从根目录触发(root)
        //先判定,当前目录里,看看是否包含咱们要删除的文件 如果是就删除 否则就跳过下一个
        //如果当前这里包含了一些目录,再针对子目录进行递归

        sacnDir(root,nameToDelete);
    }
    private static void sacnDir(File root, String nameToDelete) {
        System.out.println("[scanDir]" + root.getAbsolutePath());
        //1.先列出当前路径下包含的内容
        File[] files = root.listFiles();//此操作相当于双击d盘看到的内容
        if(files == null){
            return;
        }
        //2. 遍历当前列出的结果
        for (File f : files) {
            if(f.isDirectory()){
                //如果是目录就进一步递归
                sacnDir(f,nameToDelete);
            }else {
                //如果是普通文件则判断是否要删除
                if(f.getName().contains(nameToDelete)){
                    System.out.println("确认是否要删除" + f.getAbsolutePath() + "嘛?");
                    String choice = scanner.next();
                    if(choice.equals("y") || choice.equals("Y")){
                        f.delete();
                        System.out.println("删除成功");
                    }else {
                        System.out.println("删除取消");
                    }
                }
            }
        }
    }
}
