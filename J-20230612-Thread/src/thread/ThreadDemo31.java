package thread;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-19
 * Time: 19:19
 */
public class ThreadDemo31 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        semaphore.acquire();
        System.out.println("执行一次 P 操作");
        semaphore.acquire();
        System.out.println("执行一次 P 操作");
        semaphore.acquire();
        System.out.println("执行一次 P 操作");
        semaphore.acquire();
        System.out.println("执行一次 P 操作");
        semaphore.release();
    }
}
