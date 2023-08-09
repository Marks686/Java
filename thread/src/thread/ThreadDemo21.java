package thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-16
 * Time: 1:46
 */
//阻塞队列的使用
public class ThreadDemo21 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        blockingDeque.put("hello");
        String res = blockingDeque.take();
        System.out.println(res);
        res = blockingDeque.take();
        System.out.println(res);
    }
}
