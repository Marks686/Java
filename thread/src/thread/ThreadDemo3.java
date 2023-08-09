package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-11
 * Time: 16:21
 */
//使用匿名内部类.
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t = new Thread()
        {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        t.start();
    }
}
