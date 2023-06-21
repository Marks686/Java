package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-06-10
 * Time: 23:00
 */

class MyThread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello thread");
            try{
                Thread.sleep(1000);//休眠一秒
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();

        while(true){
            System.out.println("hello main");
            try{
                Thread.sleep(1000);//休眠一秒
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
