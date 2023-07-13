package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-12
 * Time: 13:45
 */
public class ThreadDemo10 {
    public static void main(String[] args){
        Thread t = new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("join 之前");
        try {
            t.join();//此处的join就是让当前main线程来等待t线程执行结束.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("join 之后");
    }
}
