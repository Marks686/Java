package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-23
 * Time: 19:02
 */
//通过这个代码演示多线程和单线程相比，效率上的提升
public class ThreadDemo12 {
    public static void main(String[] args) {
        //假设当前有两个变量，需要把两个变量各自自增1000w 次。(典型的CPU密集型的场景)
        //可以一个线程,先针对a自增,再针对b自增
        //还可以两个线程,分别对a 和 b自增

        //serial();
        concurrency();
    }
    //串行执行,一个线程完成
    public static void serial(){
        //为了衡量代码执行速度 加上个计时操作
        //获取当前系统的ms级时间戳
        long beg =System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("单线程执行时间: " + (end - beg) + " ms");
    }

    public static void concurrency(){
        // 使用两个线程 分别完成自增
        Thread t1 = new Thread(()->{
            long a = 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
                a++;
            }
        });
        Thread t2 = new Thread(()->{
            long b = 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
                b++;
            }
        });
        long beg = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("并发执行时间: " + (end - beg) + " ms");
    }
}
