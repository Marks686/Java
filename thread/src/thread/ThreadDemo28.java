package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-18
 * Time: 15:38
 */
public class ThreadDemo28 {
    public static void main(String[] args) throws InterruptedException {
        //这些原子类,就是基于 CAS 实现了自增 自减操作.这类操作不需要加锁 是线程安全的.
        AtomicInteger count = new AtomicInteger(0);
        //使用原子类解决线程安全问题
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                //因为java不支持运算符重载,所以只能使用普通方法来表示自增自减.
                count.getAndIncrement();//count++
                //count.incrementAndGet();//++count
                //count.getAndDecrement();//count--
                //count.decrementAndGet();//--count
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count.get());
    }
}
