package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-19
 * Time: 17:01
 */
public class ThreadDemo29 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        Integer result = futureTask.get();
        System.out.println(result);
    }
}
