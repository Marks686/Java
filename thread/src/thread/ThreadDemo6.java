package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-11
 * Time: 22:11
 */
public class ThreadDemo6 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("hello");
                }
            }
        },"mythread");
        t.start();
    }
}
