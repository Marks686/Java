package thread;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-17
 * Time: 13:32
 */
//使用标准库中的线程池
public class ThreadDemo26 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);



        for (int i = 0; i < 1000; i++) {
            int n = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello " + n);
                }
            });
        }
    }
}
