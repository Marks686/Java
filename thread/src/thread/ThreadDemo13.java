package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-24
 * Time: 14:39
 */
class Counter{
    public static int count = 0;
     synchronized public void add(){
         synchronized (this) {
             count++;
         }
     }

     public void add2(){
         count++;
     }
}
public class ThreadDemo13 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        //搞两个线程 分别针对counter 来调用5w次add方法
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.add2();
            }
        });
        t1.start();
        t2.start();
        //等待两个线程结束
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //打印最终的count值
        System.out.println("count = " + counter.count);
    }
}
