package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-11
 * Time: 16:42
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("hello");
        });
        t.start();
    }
}
