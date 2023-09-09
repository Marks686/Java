package old;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-09
 * Time: 14:52
 */
public class Car {
    private Framework framework;
    public Car(int size){
        framework = new Framework(size);
    }
    public void init(){
        System.out.println("执行了 Car 的init方法");
        // 依赖车身
        framework.init();
    }
}
