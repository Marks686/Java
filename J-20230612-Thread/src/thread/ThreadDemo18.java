package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-14
 * Time: 23:03
 */
public class ThreadDemo18 {
    //三个线程,分别打印 A,B,C. 控制三个线程固定按照 ABC 的顺序进行打印
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(()->{
            System.out.println("A");
            synchronized (locker1){
                locker1.notify();
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (locker1){
                try {
                    locker1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("B");

            synchronized (locker2){
                locker2.notify();
            }
        });
        Thread t3 = new Thread(()->{
            synchronized (locker2){
                try {
                    locker2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
        });

        t2.start();
        t3.start();
        Thread.sleep(100);
        t1.start();
    }
}
