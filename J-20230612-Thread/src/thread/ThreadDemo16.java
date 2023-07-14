package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-14
 * Time: 1:42
 */
public class ThreadDemo16 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object){
            System.out.println("wait 之前");
            object.wait();//wait不加任何参数,就一直等待,直到其他线程唤醒它
            System.out.println("wait 之后");
        }
    }
}
