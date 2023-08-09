package thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-16
 * Time: 18:16
 */
public class ThreadDemo22 {
    public static void main(String[] args) {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
        //创建两个线程来作为生产者和消费者

        Thread customer = new Thread(()->{
            while(true){
                try {
                    Integer result = blockingDeque.take();
                    System.out.println("消费元素: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();

        Thread producer = new Thread(()->{
            int count = 0;
            while (true){
                try {
                    blockingDeque.put(count);
                    System.out.println("生产元素: " + count);
                    count++;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
    }
}
