package thread;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-16
 * Time: 20:18
 */
//表示定时器中的任务
class MyTask implements Comparable<MyTask> {

    //要执行的任务内容
    private Runnable runnable;
    //任务在什么时候执行(使用毫秒时间戳表示)
    private long time;

    public MyTask(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = time;
    }

    //获取当前任务时间
    public long getTime() {
        return time;
    }

    //执行任务
    public void run(){
        runnable.run();
    }

    @Override
    public int compareTo(MyTask o) {
        //返回小于0 大于0 ==0
        //this比o小 返回 < 0
        //this比o大 返回 > 0
        //this和o相同 返回 0
        //当前需要实现:队首元素是时间最小的任务
        return (int)(this.time - o.time);
    }
}
//自己写的定时器
class MyTimer{
    //扫描线程
    private Thread t = null;
    //阻塞优先级队列 保存任务
    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    public MyTimer(){
        t = new Thread(()->{
            while (true){
                try {
                    //取出对手元素,检查队首元素任务是否到时间了
                    //如果时间没到,就把任务塞回队列里去
                    //如果时间到了,就把任务进行执行
                    synchronized (this){
                        MyTask myTask = queue.take();//阻塞队列只能先把元素出队列,才好判定,不满足还得塞回去.
                        long curTime = System.currentTimeMillis();
                        if(curTime < myTask.getTime()){
                            //还没到点,先不必执行
                            queue.put(myTask);
                            //进行wait
                            this.wait(myTask.getTime() - curTime);
                        }else{
                            //时间到了 执行任务
                            myTask.run();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
    //指定两个参数
    //第一个参数是 任务 内容
    //第二个参数是 任务 在多少毫秒之后执行 形如1000
    public void schedule(Runnable runnable,long after){
        //注意这里时间上的换算
        MyTask task = new MyTask(runnable,System.currentTimeMillis()  + after);
        queue.put(task);
        synchronized (this) {
            this.notify();
        }
    }
}
/*public class TestDemo25 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        },1000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务2");
            }
        },2000);
    }
}*/
