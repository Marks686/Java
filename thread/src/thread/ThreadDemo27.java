package thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-17
 * Time: 23:05
 */
class MyThreadPool{
    //不涉及"时间",此处只有任务 直接使用Runnable即可
    private BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
    //n表示线程的数量
    public MyThreadPool(int n){
        //创建出线程
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(()->{
                while (true){
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
    //注册任务给线程池
    public void submit(Runnable runnable){
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ThreadDemo27 {
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(10);
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
