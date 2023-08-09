package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-11
 * Time: 16:31
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        t.start();
    }
}
