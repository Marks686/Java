package thread;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-07-15
 * Time: 0:00
 */

//饿汉模式的  单例模式 实现
//此处保证 Singleton 这个类只能创建出一个实例
class Singleton{
    //在此处,先把这个实例创建出来
    private static Singleton instance = new Singleton();
    //如果需要使用这个唯一实例,统一通过 Singleton.getInstance() 方式来获取
    public static Singleton getInstance(){
        return instance;
    }
    //为了避免 Singleton 类不小心被复制出多份
    //把构造方法设为 private. 在类外面就无法通过 new 的方式来创建这个 Singleton 实例了
    private Singleton(){}
}
public class ThreadDemo19 {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s == s2);
    }
}
