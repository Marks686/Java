package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-19
 * Time: 18:17
 */
public class ThreadDemo30 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        boolean result = reentrantLock.tryLock();
        try{
            if(result){
                //做需要考虑线程安全的操作
            }else{
                // 啥都不做
            }
        }finally {
            if(result){
                reentrantLock.unlock();
            }
        }
    }
}
