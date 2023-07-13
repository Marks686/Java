package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-09
 * Time: 14:52
 */
public class ThreadDemo14 {
    public static void main(String[] args) {
        Object jiangyou = new Object();
        Object cu = new Object();

        Thread tanglaoshi = new Thread(()->{
            synchronized (jiangyou){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (cu){
                    System.out.println("汤老师把酱油和醋都拿到了");
                }
            }
        });
        Thread shiniang = new Thread(()->{
            synchronized (jiangyou){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (cu){
                    System.out.println("师娘把酱油和醋都拿到了");
                }
            }
        });
        tanglaoshi.start();
        shiniang.start();
    }
}
