package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-11
 * Time: 9:01
 */
//Runnable 作用是描述一个"要执行的任务"
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("hello thread");
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();
    }
}
