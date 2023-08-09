package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-12
 * Time: 11:35
 */
public class ThreadDemo8 {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (flag){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        Thread.sleep(3000);
        flag = false;
    }
}
