package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-14
 * Time: 2:17
 */
public class ThreadDemo17 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread t1 = new Thread(()->{
            //这个线程负责进行等待
            System.out.println("t1:wait之前");
            try {
                synchronized (object) {
                    object.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1:wait之后");
        });

        Thread t2 = new Thread(()->{
            System.out.println("t2:notify 之前");
            //notify 务必要获取到锁,才能进行通知
            synchronized (object) {
                object.notify();
            }
            System.out.println("t2:notify 之后");
        });

        t1.start();
        //此处的 sleep 500 是大概率会让当前的 t1 先执行 wait
        Thread.sleep(500);
        t2.start();
    }
}
