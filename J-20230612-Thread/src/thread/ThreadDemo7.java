package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-12
 * Time: 10:54
 */
public class ThreadDemo7 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("hello thread");
        });
        t.start();
        System.out.println("hello main");
    }
}
