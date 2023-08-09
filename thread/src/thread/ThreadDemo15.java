package thread;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-09
 * Time: 19:12
 */

class MyCounter{
    volatile public int flag = 0;
}
public class ThreadDemo15 {
    public static void main(String[] args) {
        MyCounter myCounter = new MyCounter();

        Thread t1 = new Thread(()->{
            while (myCounter.flag == 0){
                //这个循环体空着
            }
            System.out.println("t1 循环结束");
        });

        Thread t2 = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数:");
            myCounter.flag = scanner.nextInt();
        });
        t1.start();
        t2.start();
    }
}
