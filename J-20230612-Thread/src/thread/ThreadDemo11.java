package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-22
 * Time: 23:06
 */
public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                // 循环体中什么都不干 也不sleep
                for (int j = 0; j < 100000000; j++) {
                    int a = 0;
                    a += 1;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //启动之前,获取t的状态 即NEW状态
        System.out.println("start 之前: " + t.getState());
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("t 执行中的状态: " + t.getState());
        }
        t.join();
        //线程执行完毕之后,就是 TERMINATED
        System.out.println("t 结束之后: " + t.getState());
    }
}
